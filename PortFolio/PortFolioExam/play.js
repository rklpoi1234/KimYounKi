
'use strict';

(function() {

	var
		urlorigin = location.href.match(/(http:\/\/[^\/]+)/)[1],

		apptitle = document.title.indexOf('|') != -1 ? document.title.split('| ')[1] : document.title,

		$html = $(document.documentElement),
		$body = $(document.body),

		$apptitle = $('title'),
		$appicon = $('link[rel="apple-touch-icon"]'),

		$wrap = $('#wrap'),

		$listbox = $('#list'),
		$viewbox = $('#view'),

		datas = [],

		mode = 'list',

		regviewid = /\/([a-z0-9-_]+)\/?$/,

		logocontrol,
		infocontrol,
		listcontrol,
		viewcontrol,
		blocker,

		areawidth = 0,
		areaheight = 0,

		currentindex = -1,
		previndex = -1,

		hoverable = false,
		pageloaded = false;


	if ((/iphone|ipad|android/i).test(navigator.userAgent)) {
		$html.addClass('touchbased');
	} else {
		hoverable = true;
		$html.addClass('hoverable');
		if ((/(?:msie ([0-9]+)|rv:([0-9\.]+)\) like gecko)/i).test(navigator.userAgent)) {
			$html.addClass('ie');
		}
	}

	$(window).resize(pageresize).load(function() {
		pageloaded = true;
	});

	pageresize();


	logocontrol = (function() {

		var $logo = $('h1'),
			$logoimg = $logo.find('img'),
			rotationangle = 360*1.5,
			spined = false;


		$logo.click(function() {
				$html.toggleClass('info');
				if ($html.hasClass('info')) {
					$logo._css({rotation: 0, force3D: true})._animate({rotation: -720}, {duration: 650, easing: 'easeInOutQuart'});
				}
			})
			._animate({opacity: 1}, {duration: 500, delay: 500, easing: 'easeOutQuad', complete: spin});


		function spin() {
			if (spined && pageloaded) {
				$logo._animate({opacity: 0}, {duration: 300, easing: 'easeOutQuad', complete: function() {
					$logoimg.attr('style', '');
					setTimeout(function() {
						$logo.attr('style', '').addClass('home')
							._animate({opacity: 1}, {duration: 350, delay: 100, easing: 'easeOutQuad'});
						listcontrol.display();
					}, 0);
				}});
			} else {
				$logo._css({rotation: 0})._animate({rotation: rotationangle}, {duration: 1250, easing: 'easeInOutQuart', step: onspin, complete: spin});
				$logoimg._css({rotation: 0});
			}
			spined = true;
		}

		function onspin(e) {
			$logoimg._css({rotation: -rotationangle*e.ratio});
		}

		function move(x, y) {
			// settranslate($logo[0], x, y);
			$logo._css({x: x, y: y, rotation: 0, force3D: true});
		}
		

		return {
			move: move
		}

	})();


	infocontrol = (function() {

		var $info = $('#info'),
			$welcome = $info.find('.description a'),
			$contacts = $info.find('#contacts'),
			$gohome = $info.find('.home a');

		$welcome.click(function(e) {
			$contacts.toggleClass('show');
			e.preventDefault();
		});

		$gohome.click(function(e) {
			$html.removeClass('info');
			listcontrol.expand();
			e.preventDefault();
		});

	})();


	listcontrol = (function() {

		var 
			$list = $listbox.find('ul:first'),

			$items = [],
			$links = [],
			$thumbs = [],

			$title = $listbox.find('h5'),
			$indicator = $listbox.find('.indicator'),

			$scroller = $({x: 0}),
			scroller = null,

			sidepadding = 0,
			itemwidth = 120,
			itempadding = 15,
			focusgap = 30,

			centerindex = -1,
			hoverindex = -1,
			titleindex = -1,

			leavetimer = null,

			holdsnap = false,
			issizing = false,
			reduced = false,

			triggered = false,

			numitems;


		itemwidth = itemwidth+itempadding*2;
		sidepadding = areawidth/2-itemwidth/2;

		$list.find('> li').each(function(i) {

			$items[i] = $(this);
			$links[i] = $(this.children[0]).attr('data-index', i)
				// .mouseenter(hover).mouseleave(leave)
				.click(show);
			_move.handleclick($links[i][0], show);

			// extract datas
			datas[i] = {
				id: $links[i].attr('href').match(regviewid)[1],
				root: $links[i].attr('href'),
				title: $links[i][0].children[0].innerHTML,
				description: $items[i].find('p.d').html().replace(/\t/g, '').replace(/\n/g, '<br>').replace(/(^<br>|<br>$)/g, ''),
				date: $items[i].find('p.t').html(),
				color: $items[i].attr('data-color'),
				bright: $items[i].hasClass('bright')
			};

			$thumbs[i] = $('<span class="thumb"><img src="'+ datas[i].root +'thumbnail.png" alt=""></span>')
				.insertBefore($links[i][0].children[0]).children();

		});

		numitems = $items.length;

		// create side gradation - not in use
		(function() {
			return;
			var $gradationbox = $('<div class="side-gradation" />'),
				i = 0, numbars = 10, html = [];
			for (; i < numbars; i++) {
				html.push('<div style="left: ', i, 'px; opacity: ', (1-(1/numbars)*i), ';"></div>');
			}
			$gradationbox.html(html.join('')).insertBefore($list);
			$gradationbox.clone().addClass('r').appendTo($listbox);
		})();

		setlistsize();

		$list._move({
				direction: 'x',
				onmove: function(e) {
					focusitem(e);
				},
				onreset: function(e) {
					!issizing && focusitem(e);
				},
				snap: [function(v) {
					return holdsnap ? v : Math.round(v/itemwidth)*itemwidth;
				}],
				scroll: {
					wheelforx: true
				}
			});

		scroller = $list.data('_move');

		hoverable && $list.mousedown(function() {
				$html.addClass('grabbing');
			}) && $html.mouseup(function() {
				$html.removeClass('grabbing');
			});

		

		function hover() {
			var index = parseInt(this.getAttribute('data-index'));
			clearTimeout(leavetimer);
			if (index != hoverindex) {
				settitle(index, false, true);
				hoverindex = index;
			}
		}

		function leave() {
			clearTimeout(leavetimer);
			leavetimer = setTimeout(leaveaction, 100);
		}

		function leaveaction() {
			settitle(centerindex, false, true);
			hoverindex = centerindex;
		}

		function setlistsize(_itemwidth) {
			sidepadding = Math.ceil(areawidth/2-(_itemwidth || itemwidth)/2);
			$list.css({
				width: itemwidth*numitems,
				padding: '0 '+ sidepadding +'px'
			});
		}

		function show(e, _triggered) {

			var index = parseInt(this.getAttribute('data-index'));

			e.preventDefault();
			if (currentindex == index) {
				return;
			}

			blocker.show();

			triggered = _triggered;

			if (!reduced) {
				reduce(index);
			} else {
				if (centerindex == index) {
					viewcontrol.view(index, triggered);
				} else {
					scrolltoitem(index);
				}
				$links[currentindex].removeClass('on');
			}

			previndex = currentindex;
			currentindex = centerindex = index;

			$links[currentindex].addClass('on');

			// $html.addClass('view');

			return;

		}

		function readytomove() {
			holdsnap = true;
		}

		function moveend() {
			holdsnap = false;
			reduced && viewcontrol.view(currentindex, triggered);
		}

		function scrolltoitem(index) {
			var nowx = itemwidth*centerindex,
				tox = itemwidth*index;
			readytomove();
			$scroller[0].x = nowx;
			$scroller._stop()._animate({x: tox}, {duration: Math.min(750, Math.max(450, Math.abs(nowx-tox)*5)), easing: 'easeInOutCubic',
				step: function(e) {
					scroller.left(this[0].x, true);
				},
				complete: moveend
			});
		}

		function reduce(toindex) {

			var fromindex = centerindex,
				titlesetted = false;

			issizing = true;
			readytomove();

			$listbox._animate({height: 100, y: -0}, {duration: 1100, easing: 'easeInOutQuint',
			// $listbox._animate({height: 100, y: -0}, {duration: 1, easing: 'easeInOutQuint',

				step: function(e) {

					var rounding = Math[e.ratio > 0.5 ? 'floor' : 'ceil'],
						size = 120-70*e.ratio,
						i = 0;

					// itempadding = rounding(15-8*e.ratio);
					itempadding = 15-8*e.ratio;
					itemwidth = size + itempadding*2;

					setlistsize(rounding(itemwidth));

					for (; i < numitems; i++) {
						$items[i][0].style.width = $items[i][0].style.height = rounding(size) +'px';
						$items[i][0].style.marginTop = -rounding(size)/2 +'px';
					}

					logocontrol.move(0, 15*e.ratio);

					$title[0].style.fontSize = rounding(13-2*e.ratio) +'px';
					$title[0].style.marginTop = rounding(60-40*e.ratio) +'px';

					scroller.reset();
					scroller.left(itemwidth*fromindex+(itemwidth*toindex-itemwidth*fromindex)*e.ratio, true);

					// if scroller onmove event didn't fired, manually do.
					if (!centerindex && !toindex) {
						focusitem({x: 0});
					}

					if (e.ratio > 0.5 && !titlesetted) {
						settitle(toindex);
						titlesetted = true;
					}

				},

				complete: function() {
					$html.addClass('view');
					issizing = false;
					reduced = true;
					moveend();
				}

			});

		}

		function expand() {

			if (!reduced) {
				return;
			}

			setpageinfo(apptitle, urlorigin + '/resource/app-icon.png');

			$links[currentindex].removeClass('on');

			readytomove();
			blocker.show();

			issizing = true;

			$listbox._animate({height: areaheight}, {duration: 1100, easing: 'easeInOutQuint',

				step: function(e) {

					var rounding = Math[e.ratio > 0.5 ? 'ceil' : 'floor'],
						size = 50+70*e.ratio,
						i = 0;

					itempadding = 7+8*e.ratio;
					itemwidth = size + itempadding*2;

					setlistsize(rounding(itemwidth));

					for (; i < numitems; i++) {
						$items[i][0].style.width = $items[i][0].style.height = rounding(size) +'px';
						$items[i][0].style.marginTop = -rounding(size)/2 +'px';
					}

					logocontrol.move(0, 15-15*e.ratio);

					$title[0].style.fontSize = rounding(11+2*e.ratio) +'px';
					$title[0].style.marginTop = rounding(20+40*e.ratio) +'px';

					scroller.reset();
					scroller.left(itemwidth*centerindex, true);

					// if scroller onmove event doesn't fire, manually do.
					if (!centerindex) {
						focusitem({x: 0});
					}

				},

				complete: function(e) {
					mode = 'list';
					$html.removeClass('view');
					issizing = false;
					reduced = false;
					viewcontrol.hide();
					blocker.hide();
					historystate.push('');
					currentindex = -1;
					moveend();
				}

			});

		}

		function settitle(index, withoutanimation, withx) {

			var title, xgap;

			if (!pageloaded || titleindex == index) {
				return;
			}

			title = datas[index].title.toLowerCase();

			if (withoutanimation) {
				$title.html(title);
			} else {
				if (withx) {
					xgap = (index-centerindex)*itemwidth;
					$title._animate({x: !xgap  ? xgap : xgap > 0 ? xgap+focusgap : xgap-focusgap}, {duration: 500, easing: 'easeOutQuart'});
				}
				$title._animate({opacity: 0}, {duration: 100, easing: 'linear', complete: function() {
					$title.html(title)._animate({opacity: 1}, {duration: 350, easing: 'linear'});
				}});
			}

			titleindex = index;

		}

		function focusitem(e, withoutanimation) {

			var x = e.x,
				index = Math.max(0, Math.min(numitems-1, Math.round((x+focusgap)/itemwidth))),
				distancebase = itemwidth > 90 ? 3 : 2,
				itemleft, i;
			
			/* don't use hover/leave
			if (hoverindex != centerindex) {
				leaveaction();
			}
			*/

			if (index != centerindex) {
				!issizing && settitle(index, withoutanimation);
				centerindex = hoverindex = index;
			}

			for (i = 0; i < numitems; i++) {
				itemleft = sidepadding+(i+1)*itemwidth;
				if (x > itemleft || itemleft > x+areawidth+itemwidth) {
					$items[i].removeClass('show');
					// $items[i][0].style.zIndex = 0;
					// $items[i][0].style.visibility = '';
				} else {
					$items[i].addClass('show');
					// $items[i][0].style.zIndex = '';
					// $items[i][0].style.visibility = 'visible';
					settranslate($items[i][0], sidepadding + i*itemwidth + itempadding + Math.max(-focusgap, Math.min(focusgap, (x-itemwidth*i)*-1/distancebase)));
				}
				// 	$items[i]._css({
				// 		scale: 1-Math.abs(x-itemwidth*i)/(areawidth/0.25),
				// 		opacity: 1-Math.abs(x-itemwidth*i)/(areawidth/1.2)
				// 	});
			}

		}

		// first intro
		function display() {

			var viewid = location.href.match(regviewid),
				titledisplayed = false,
				viewindex, i;

			if (viewid) {
				viewindex = getindex(viewid[1]);
			}

			// listmode
			if (viewindex === undefined) {
				for (i = 0; i < numitems; i++) {
					if ($items[i].hasClass('show')) {
						$links[i]._css({x: areawidth/4, force3D: true})._animate({x: 0}, {duration: 750, delay: i*85+50, easing: 'easeOutQuart', step: !i ? onshowstepfirstitem : $.noop, complete: !$items[i+1] || !$items[i+1].hasClass('show') ? onshowlastitem : onshow});
						$items[i]._animate({opacity: 1}, {duration: 900, delay: i*85+50, easing: 'easeOutQuad'});
					} else {
						$items[i].css({opacity: 1});
					}
				}
			// view mode
			} else {
				scroller.left(itemwidth*viewindex, true);
				detail(viewindex);
				$links[viewindex].removeClass('on');
				for (i = 0; i < numitems; i++) {
					if (i != viewindex) {
						if (60*(Math.abs(i-viewindex)) > areawidth/2) {
							$items[i].css({opacity: 1});
						} else {
							$links[i]._css({x: areawidth/8 * (i-viewindex), force3D: true})._animate({x: 0}, {duration: 700, delay: 35*Math.abs(viewindex-i)+350, easing: 'easeOutCubic', complete: onshow});
							$items[i]._animate({opacity: 1}, {duration: 800, delay: 35*Math.abs(viewindex-i)+350, easing: 'easeOutQuad'});
						}
					} else {
						$links[i]._css({scale: 0.5, force3D: true})._animate({scale: 1}, {duration: 500, easing: Back.easeOut.config(5)});
						$items[i]._animate({opacity: 1}, {duration: 150, easing: 'easeOutQuad', complete: function() {
							$links[viewindex].addClass('on');
						}});
					}
				}
			}

			function onshow() {
				this[0].style.cssText = '';
			}

			function onshowstepfirstitem(e) {
				if (!titledisplayed && e.ratio > 0.65) {
					settitle(0);
					titledisplayed = true;
				}
			}

			function onshowlastitem() {
				blocker.hide();
				onshow.call(this);
				historystate.poped();
			}

		}

		function follow(y, duration, easing) {
			$links[centerindex]._animate({y: y, force3D: true}, {duration: duration, easing: easing, step: function(e) {
				if (e.ratio > 0.1) {
					$links[currentindex]._animate({y: 0}, {duration: 300, easing: 'easeOutQuint'});
				}
			}});
		}

		function givemethumb(index) {
			return $thumbs[index].clone();
		}

		function detail(index) {
			$links[index].trigger('click', true);
		}

		function resize() {
			setlistsize();
			scroller.reset();
			scroller.left(itemwidth*centerindex, true);
		}

		return {
			detail: detail,
			follow: follow,
			givemethumb: givemethumb,
			expand: expand,
			display: display,
			resize: resize
		}

	})();


	viewcontrol = (function() {

		var
			$loader = $('.view-loader'),
			$loaderimg = $loader.children(),

			$cover,
			$coverchidren,

			$coverlayer = $('<div class="cover semi" />'),
			$covercolored = $('<div class="cover semi colored" />'),

			$coverbottom = $('<canvas class="cover bottom" />'),
			coverbottomcontext = $coverbottom[0].getContext('2d'),
			coverbottomheight = 0,

			$detail = $viewbox.find('.detail'),
			$title = $detail.find('h2'),
			$description = $detail.find('.description'),
			$date = $detail.find('.date'),
			$sharebuttons = $detail.find('.share a'),

			$iframe,
			$previframe,

			listheight,
			viewheight,

			// covercolor = '#005083', // blue
			// covercolor = '#854b28',
			// covercolor = '#9b87bc',
			// must be matched with [body] color
			covercolor = '#a12a58',

			loadery,

			step = 0,

			rotationangle = 360*1.5,
			loaded = false;
			

		function view(index, triggered) {

			mode = 'view';

			setpageinfo(datas[currentindex].title +' | '+ apptitle, urlorigin + datas[currentindex].root +'thumbnail.png');

			step = 0;
			loaded = false;

			messagetopage('pause');

			if (!triggered) {
				historystate.push(datas[index].id);
			}

			pageresize();

			// covercolor = datas[currentindex].color;

			loadery = (areaheight-listheight)/2+listheight-50;

			$loader.empty()._css({y: 0, rotation: 0, opacity: 0, visibility: 'visible'})
				._animate({opacity: 1}, {duration: 300, easing: 'easeOutQuint'})
				._animate({y: loadery}, {duration: 650, easing: 'easeInOutQuint', complete: spin});

			$loaderimg = listcontrol.givemethumb(index).appendTo($loader); // change src of image, it occurs short term in mobile

			listcontrol.follow(loadery, 650, 'easeInOutQuint');

		}

		function onviewload() {
			if (loaded) {
				messagetopage('play');
			}
			loaded = true;
		}

		function spin() {

			var coversize = Math.sqrt(areawidth/2*areawidth/2+areaheight/2*areaheight/2)*2;

			onspined();

			$coverlayer.css({background: 'rgb('+ Math.round(Math.random()*155+100) +', '+ Math.round(Math.random()*155+100) +', '+ Math.round(Math.random()*155+100) +')'})
				._animate({scale: (Math.max(areawidth, viewheight)*1.1)/50, force3D: true}, {duration: 750, delay: 100, easing: 'easeInOutQuint'})
				.appendTo($viewbox);
			$covercolored.css({background: datas[currentindex].color})
				._animate({scale: (Math.max(areawidth, viewheight)*1.1)/50, force3D: true}, {duration: 750, delay: 200, easing: 'easeInOutQuint'})
				.appendTo($viewbox);

			$iframe = $('<iframe src="'+ datas[currentindex].root +'" name="layer-iframe" width="100%" height="0" frameborder="0" scrolling="no" allowTransparency="true"></iframe>')
				.css({opacity: 0})
				.load(onviewload)
				.appendTo($viewbox);

		}

		function onspin(e) {
			$loaderimg._css({rotation: -rotationangle*e.ratio});
		}

		function onspined() {
			if (loaded) {

				step = 1;

				$loader._stop()._animate({y: loadery+viewheight}, {duration: 1000, step: setcoverbottom, easing: 'easeInOutCubic'});

				$cover = $([
						'<div class="cover">',
							'<div class="inside">',
								'<h6>', datas[currentindex].title, '</h6>',
								'<p>', datas[currentindex].date, '</p>',
							'</div>',
						'</div>'
					].join(''))
					._css({y: -viewheight, background: covercolor, force3D: true})
					._animate({y: 0}, {duration: 750, easing: 'easeInOutCubic', delay: 250, step: oncovershow, complete: oncovered})
					.appendTo($viewbox);

				$coverchidren = $cover.children().children();

				$coverbottom.removeClass('upper').appendTo($viewbox);
				coverbottomheight = $coverbottom[0].offsetHeight;
				$coverbottom[0].height = coverbottomheight;

			} else {
				$loader._css({rotation: 0})._animate({rotation: rotationangle}, {duration: 1000, easing: 'easeInOutQuart', step: onspin, complete: onspined});
				$loaderimg._css({rotation: 0});
			}
		}

		function setcoverbottom(e) {

			var value = viewheight*0.85,
				y = value-Math.abs((viewheight*e.ratio)-value);

			$coverbottom[0].width = areawidth;
			coverbottomcontext.beginPath();
			coverbottomcontext.moveTo(0, 0);

			if (step == 1) {
				y = Math.min(150, areawidth/10)*y/(value);
				coverbottomcontext.quadraticCurveTo(areawidth/2, y, areawidth, 0);
			} else {
				y = 150*y/(value);
				coverbottomcontext.quadraticCurveTo(areawidth/2, y, areawidth, 0);
				coverbottomcontext.lineTo(areawidth, coverbottomheight);
				coverbottomcontext.lineTo(0, coverbottomheight);
				$coverbottom._css({y: (viewheight+100)*e.ratio, force3D: true});
			}

			coverbottomcontext.fillStyle = covercolor;
			coverbottomcontext.fill();

		}

		function oncovershow(e) {
			// $coverchidren._css({y: -(viewheight*(1-e.ratio))*0.5, opacity: (e.ratio-0.5)/0.5, force3D: true});
			// $coverchidren._css({y: (viewheight*(1-e.ratio))/2, force3D: true});
			$coverchidren._css({y: viewheight*(1-e.ratio), opacity: (e.ratio-0.5)/0.5, force3D: true});
			$coverbottom._css({y: viewheight*e.ratio, force3D: true});
		}

		function oncovered() {

			var delayforread = 1000;

			step = 2;

			$html[datas[currentindex].bright ? 'addClass' : 'removeClass']('bright');
			$viewbox.removeClass('detail').addClass('covered');

			$cover._animate({y: viewheight}, {duration: 1000, delay: delayforread, easing: 'easeInQuint'/*, step: setcoverbottom*/});
			// $coverbottom.addClass('upper');

			$previframe && $previframe.remove();
			$previframe = $iframe.css({opacity: '', top: 0});

			$covercolored.addClass('fill')._css({scale: 1})
				._animate({y: viewheight}, {duration: 1000, delay: delayforread+90, easing: 'easeInQuint'});
			$coverlayer.addClass('fill')._css({scale: 1})
				._animate({y: viewheight}, {duration: 1000, delay: delayforread+200, easing: 'easeInQuint', complete: onuncovered});

		}

		function onuncovered() {
			messagetopage('play');
			$cover.remove();
			$coverlayer.detach().removeClass('fill')._css({y: 0});
			$covercolored.detach().removeClass('fill')._css({y: 0});
			$coverbottom.detach();
			$loader._css({visibility: 'hidden'});
			blocker.hide();
			historystate.push(datas[currentindex].id);
		}

		function messagetopage(message) {
			$previframe && $previframe[0].contentWindow.postMessage(message, '*');
		}

		function hide() {
			$viewbox.css({visibility: 'hidden'}).removeClass('covered');
			$previframe && $previframe.remove();
			$previframe = null;
		}

		function resize() {
			if (mode == 'view') {
				listheight = $listbox[0].offsetHeight;
				viewheight = areaheight-listheight;
				$viewbox.css({top: listheight, height: viewheight, visibility: 'visible'});
			}
		}

		return {
			view: view,
			hide: hide,
			resize: resize
		}

	})();

	// listcontrol.detail(6);

	blocker = (function() {

		var $box = $('<div class="blocker" />'),
			blocked = false;

		$box.on('touchmove wheel mousedown', function(e) {
			e.preventDefault();
		});
		show();

		function show() {
			blocked = true;
			$box.appendTo($body);
		}

		return {
			show: show,
			hide: function() {
				blocked = false;
				$box.detach();
			},
			blocked: function() {
				return blocked;
			}
		}

	})();

	var historystate = (function() {

		var viewindex;

		$(window).on({'popstate': poped});

		function push(id) {
			var locationhref = location.href;
			if (id == '' && !new RegExp(urlorigin +'\/?$').test(locationhref)) { // list
				window.history.pushState('', '', '/');
			} else if (id && !new RegExp(id +'\/?$').test(locationhref)) {
				window.history.pushState('', '', '/'+ id +'/');
			}
		}

		function poped() {

			var viewid;

			if (!blocker.blocked()) {
				viewid = location.href.match(regviewid);
				if (viewid) {
					listcontrol.detail(getindex(viewid[1]));
				} else {
					mode != 'list' && listcontrol.expand();
				}
			}

		}

		return {push: push, poped: poped}

	})();

	function getindex(viewid) {
		for (var key in datas) {
			if (datas[key].id == viewid) {
				return key;
			}
		};
	}

	function setpageinfo(title, appiconurl) { 
		$apptitle[0].innerHTML = title;
		// $appicon[0].href = appiconurl;
	}

    function invertcolor(color) {
    	return '#'+ ('000000'+(0xFFFFFF^parseInt(color.substring(1), 16)).toString(16)).slice(-6);
    }

	function pageresize() {

		areawidth = window.innerWidth;
		areaheight = window.innerHeight;

		// $wrap.css('height', areaheight);

		$html[641 > areawidth ? 'addClass' : 'removeClass']('small');

		listcontrol && listcontrol.resize();
		viewcontrol && viewcontrol.resize();

	}

	function settranslate(target, x, y) {
		x = x || 0;
		y = y || 0;
		target.style.WebkitTransform =
		target.style.transform = 'translate3d('+ x +'px, '+ y +'px, 0)';
		target.style.msTransform = 'translate('+ x +'px, '+ y +'px)';
	}

})();