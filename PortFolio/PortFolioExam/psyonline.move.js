/*
* Move elements.
* https://github.com/psyonline/move
* by @psyonline (http://www.psyonline.kr/, majorartist@gmail.com)
* License - http://creativecommons.org/licenses/by-sa/2.0/kr/
*/
;(function() {

	'use strict';

	var
		isoldie = (/msie/i).test(navigator.userAgent), // ie < 11
		poorbrowser = (/msie [5-8]/i).test(navigator.userAgent),

		$html = document.documentElement,
		$body = null,

		items = [],

		$blocker = create('<div style="position: fixed; left: 0; top: 0; right: 0; bottom: 0; background: #000; z-index: 9999999; opacity: 0;" />'),
		blockeradded = false,

		checkfunctionnames = '',
		functions,

		indexdataname = 'data-dragable-index',

		currentmoveproperty = '',

		supportonwheelevent = 'onwheel' in document || (isoldie && !poorbrowser),

		regblanks = /(	| )+/g,
		regisx = /^(x|f)/,
		regisy = /^(y|f)/,

		pointerenabled = window.navigator.pointerEnabled || window.navigator.msPointerEnabled || false,

		transformname = 'transform',
		transformable = true,
		transform3dable = true,

		moveoption = {
			minduration: 500,
			maxduration: 1750,
			normal: {easing: 'easeOutCubic', onupdate: onanimate, onend: onanimated},
			wheel: {easing: 'easeOutQuart', onupdate: onbackanimate, onend: onanimated},
			back: {easing: 'easeOutCubic', onupdate: onbackanimate, onend: onbackanimated},
			zoom: {duration: 600, easing: 'easeInOutCirc', onupdate: onzoomanimate, onend: onanimated}
		},

		minmovesize = 2,

		prevbodycsstext,
		prevbodyonselectstart;


	window._move = initialize;

	if (window.$) {
		$.fn._move = function(_option) {
			if (!_option || $.isPlainObject(_option)) {
				this.each(function() {
					$(this).data('_move', initialize(this, _option));
				});
			// } else if ( typeof(_option) == 'string' && checkfunctionnames.test(_option) ) {
			// 	this.each(function() {
			// 		functions[_option].call(this);
			// 		if ( _option != 'reset' ) {
			// 			functions.reset.call(this);
			// 		}
			// 	});
			}
			return this;
		}
	}

	/*
		$(window).resize(function() {
			$.each(items, reset);
		});
	*/

	function initialize(target, _option) {

		var index = items.length,
			item, mover, touchaction;


		// _option = $.extend(true, {}, _option);
		_option = _option || {};

		_option.direction = (_option.direction || 'auto').replace(regblanks, '');
		_option.animate = _option.animate === false ? false : true;
		_option.throwable = _option.throwable === false ? false : true;
		_option.outofbounds = _option.outofbounds === false ? false : true;
		_option.preventtouches = _option.preventtouches === false ? false : true;

		item = {
			a: true, // enabled
			c: _option.classongrabbing === undefined ? 'grabbing' : _option.classongrabbing,
			d: false, // swipe direction
			e: { // each event handlers for handle event from document element
				m: createeventhandler('move', target, index),
				u: createeventhandler('up', target, index),
				s: createeventhandler('snapafterwheel', target, index)
			},
			h: target.offsetHeight,
			i: index,
			l: 0, // last move time,
			m: 'd', // move by. d = drag, w = wheel, c = custom
			o: _option,
			p: {}, // points
			q: false, // target is out of bounds
			r: 0, // check need return to bounds
			s: null, // scroll mode options
			t: {
				min: _option.minduration || moveoption.minduration,
				max: _option.maxduration || moveoption.maxduration
			},
			$t: target,
			u: poorbrowser || !transformable || _option.usetransform === false ? 'left-top' :
				!transform3dable || _option.usetransform == '2d' ? 'x-y-2d' :
				'x-y',
			v: !!_option.valuesonly,
			w: target.offsetWidth,
			x: 0, // current x
			y: 0, // current y
			_x: 0, // destination x
			_y: 0, // destination y
			z: 1, // current scale
			_z: 1, // destination scale
			z_: null // scale mode options
		};

		item.$t.setAttribute(indexdataname, index);

		if (!item.v) {

			item.$t.style[transformname +'Origin'] = '0 0 0';
			item.$t.style.willChange = 'transform';
			if (getstyle(item.$t, 'position') == 'static') {
				item.$t.style.position = 'relative';
			}

			// set ms tablet enable touch direction
			if (pointerenabled) {
				touchaction = _option.direction == 'x' ? 'pan-y' : _option.direction == 'y' ? 'pan-x' : 'none';
				if (window.navigator.pointerEnabled) {
					item.$t.style.cssText += 'touch-action: '+ touchaction +';';
				} else if (window.navigator.msPointerEnabled){
					item.$t.style.cssText += '-ms-touch-action '+ touchaction +';';
				}
			}

		}

		addevent(item.$t, {'mousedown touchstart': down, 'dragstart': preventdefault});

		if (_option.scroll) {
			item.s = typeof(_option.scroll) == 'object' ? _option.scroll : {};
			item.s.wheelanimate = item.s.wheelanimate === false ? false : true;
			item.s.preventwheels = item.s.preventwheels === false ? false : true;
			item.s.usewheel !== false && addevent(item.$t, supportonwheelevent ? {'wheel': wheel} : {'mousewheel DOMMouseScroll': wheel});
		}

		if (_option.scale) {
			item.z_ = typeof(_option.scale) == 'object' ? _option.scale : {};
			item.z_.min = item.z_.min || item.z_.min === 0 ? item.z_.min : 1;
			item.z_.max = item.z_.max || 1;
			item.z = Math.max(item.z_.min, Math.min(item.z_.max, item.z_.initial || 1));
			delete item.z_.initial;
		}

		if (_option.snap) {
			item.e.s = createeventhandler('snapafterwheel', target, index);
			item.e.t = null; // snap timer
		}

		if (!isarray(_option.bounds)) {
			if (iselement(_option.bounds)) {
				item.$b = _option.bounds;
			} else {
				item.$b = target.parentNode;
			}
			if (item.v) {
				item.o.bounds = [-Infinity, -Infinity, Infinity, Infinity];
			} else {
				item.o.bounds = [0, 0, 0, 0];
			}
		}

		items[index] = item;

		mover = controller.set({index: index});

		if (!$body) {
			$body = document.body;
		}

		reset(index, true);

		return mover;

	}

	var controller = {

		left: function(x, withoutanimation) {
			if (x == undefined) {
				return -items[this.index].x;
			}
			movebox(this.index, -x, '', '', '', withoutanimation);
		},

		top: function(y, withoutanimation) {
			if (y == undefined) {
				return -items[this.index].y;
			}
			movebox(this.index, '', -y, '', '', withoutanimation);
		},

		to: function(x, y, withoutanimation) {
			movebox(this.index, -x, -y, '', '', withoutanimation);
		},

		scale: function(value, percentx, percenty, withoutanimation) {
			if (value == undefined || value == items[this.index].z) {
				return items[this.index].z;
			}
			setscale(this.index, value, percentx, percenty, withoutanimation);
		},

		enable: function() {
			items[this.index].a = true;
		},

		disable: function() {
			items[this.index].a = false;
		},

		reset: function() {
			reset(this.index);
		},

		set: function(target) {
			var key;
			for (key in this) {
				if (key != 'set') {
					target[key] = this[key];
				}
			}
			return target;
		}

	}

	function reset(index, frominitialize) {

		var item = items[index],
			x, y;

		setbounds(item, frominitialize === true);

		x = getedgex(item);
		y = getedgey(item);
		
		setposition(item, x, y);

		fireevent(item, 'reset', x, y);

	}

	function setbounds(item, setdefault) {

		var bounds = item.o.bounds.slice(),
			boundwidth, boundheight,
			x, y, itemwidth, itemheight;

		if (item.v) {
			item.b = bounds;
			return;
		}

		itemwidth = item.$t.offsetWidth;
		itemheight = item.$t.offsetHeight;

		item.w = itemwidth*item._z;
		item.h = itemheight*item._z;

		if (item.$b) { // bounds is element
			boundwidth = item.$b.offsetWidth;
			boundheight = item.$b.offsetHeight;
		} else {
			boundwidth = bounds[2];
			boundheight = bounds[3];
		}
		if (item.s || itemwidth > boundwidth) {
			bounds[2] = bounds[0];
			bounds[0] = boundwidth-item.w;
			if (setdefault) { // set to default position
				item.x = bounds[2];
			}
		} else {
			bounds[2] = item.s ? item.w : boundwidth-item.w;
			if (setdefault) { // set to default position
				item.x = bounds[0];
			}
		}
		if (item.s || itemheight > boundheight) {
			bounds[3] = bounds[1];
			bounds[1] = boundheight-item.h;
			if (setdefault) { // set to default position
				item.y = bounds[3];
			}
		} else {
			bounds[3] = item.s ? item.h : boundheight-item.h;
			if (setdefault) { // set to default position
				item.y = bounds[1];
			}
		}
		bounds[4] = boundwidth;
		bounds[5] = boundheight;
		item.b = bounds.slice();

		// displaybounds(index, bounds, item.$t.parentNode); // test

	}

	function down(e) {

		var index, item;

		if (2 > e.which) {

			index = getindex(this);
			item = items[index];

			if (!item.a) {
				return false;
			}

			stopanimation(index);

			setposition(item, getedgex(item, true), getedgey(item, true));

			item.p.d = getpoint(e);
			item.p.m = item.p.l = item.p.d.slice();
			item.p.p = [item.x, item.y];

			item.m = 'd';

			addevent($html, {
				'mousemove touchmove': item.e.m,
				'mouseup touchend': item.e.u
			});

			if (e.type == 'mousedown' && item.c) {
				$body.className += ' '+ item.c;
			}

			disablebodyselect();

			e.preventDefault();

		}

	}

	function disablebodyselect() {
		prevbodycsstext = $body.style.cssText;
		$body.style.cssText += '-webkit-user-select: none; -moz-user-select: none; -ms-user-select: none; user-select: none;';
		prevbodyonselectstart = $body.onselectstart;
		$body.onselectstart = returnfalse;
	}

	function enablebodyselect() {
		$body.style.cssText = prevbodycsstext;
		$body.onselectstart = prevbodyonselectstart;
	}

	function move(index, e) {

		var	item = items[index],
			points = item.p,
			bounds = item.b,
			x, y, degree;


		if (points.c > 0) { // save points one step before.
			points.k = points.l;
		}

		points.l = points.m;
		points.m = getpoint(e);

		if (!item.d) {
			item.d = item.o.direction;
			//  / 0 \
			// 90   90
			//  \180/
			degree = Math.abs((Math.atan2(points.d[0]-points.m[0], points.d[1]-points.m[1])*180)/Math.PI);
			if (!item.o.preventtouches) {
				if ((item.d == 'x' && (45 > degree || degree > 135)) ||
					(item.d == 'y' && (degree > 45 && 135 > degree))) {
					removeeventsformove(item);
					return true;
				}
			}
			if (item.d == 'x,y') {
				item.d = degree > 45 && 135 > degree ? 'x' : 'y';
			}
			if (item.d == 'auto') {
				item.d = 121 > degree && degree > 59 ? 'x' : 31 > degree || degree > 149 ? 'y' : 'free';
			}
		}

		if (regisx.test(item.d)) {
			x = points.p[0]+points.m[0]-points.d[0];
			if (!item.o.outofbounds) {
				x = getedgex(item, true, x);
			}
		}
		if (regisy.test(item.d)) {
			y = points.p[1]+points.m[1]-points.d[1];
			if (!item.o.outofbounds) {
				y = getedgey(item, true, y);
			}
		}

		setposition(item, x, y);

		item.l = gettime();
		points.c++;

		if (!blockeradded && e.type != 'touchmove' &&
			Math.max(Math.abs(points.d[0]-points.m[0]), Math.abs(points.d[1]-points.m[1])) > minmovesize) {
			$body.appendChild($blocker);
			blockeradded = true;
		}

		e.preventDefault();

	}

	function up(index, e) {

		var	item = items[index],
			points = item.p,
			lastpoint = points.k || points.l,
			movedx = points.m[0]-points.l[0],
			movedy = points.m[1]-points.l[1],
			x, y;

		if (item.o.throwable && (!item.q || 
				((item.q == 1 || item.q == 3) && 0 > movedx) ||
				((item.q == -1 || item.q == -3) && 0 < movedx) ||
				((item.q == 2 || item.q == 3) && 0 > movedy) ||
				((item.q == -2 || item.q == -3) && 0 < movedy)
			) && 100 > gettime()-item.l) {
			if (regisx.test(item.d) && Math.abs(movedx) > minmovesize) {
				x = item.x+(points.m[0]-lastpoint[0])*20;
			}
			if (regisy.test(item.d) && Math.abs(movedy) > minmovesize) {
				y = item.y+(points.m[1]-lastpoint[1])*20;
			}
			movebox(index, x, y);
		} else if (item.q) {
			item.r = 1;
			onanimated.call(items[index]);
		} else {
			movebox(index, x, y, 'back');
		}

		item.d = false;
		item.p.c = 0;
		item.p.k = null;

		removeeventsformove(item);

		if (blockeradded) {
			removeme.call($blocker);
			blockeradded = false;
		}

		if (item.c) {
			$body.className = $body.className.replace(item.c, '');
		}

		// e.preventDefault();

	}

	function wheel(e) {

		var index, item, bounds,
			deltax, deltay, x, y;

		if (e.ctrlKey) { // zoomming action in some browsers
			return true;
		}

		index = getindex(this);
		item = items[index];

		if (!item.a) {
			return false;
		}

		bounds = item.b;
		deltax = e.deltaX !== undefined ? e.deltaX : e.wheelDeltaX || 0;
		deltay = e.deltaY !== undefined ? e.deltaY : e.wheelDeltaY !== undefined ? e.wheelDeltaY : e.detail || e.wheelDelta*-1;

		if (item.s.wheelforx && !deltax) {
			deltax = deltay;
			deltay = 0;
		}
		if (item.o.direction == 'x') {
			deltay = 0;
		} else if (item.o.direction == 'y') {
			deltax = 0;
		}

		if (item.s.wheelanimate && 2 > Math.max(Math.abs(deltax), Math.abs(deltay))) {
			e.preventDefault();
			return false;
		}

		stopanimation(index);

		// sync _x(_y) with x(y)
		if (item.m != 'w') {
			item._x = item.x;
			item._y = item.y;
			item.m = 'w';
		}

		if (!item.s.preventwheels && (
			((deltax > 0 && item.x == bounds[0]) || (0 > deltax && item.x == bounds[2])) ||
			((deltay > 0 && item.y == bounds[1]) || (0 > deltay && item.y == bounds[3]))
			)) {
			return true;
		}

		item._x = Math.max(bounds[0], Math.min(bounds[2], item._x-deltax));
		item._y = Math.max(bounds[1], Math.min(bounds[3], item._y-deltay));

		if (item.s.wheelanimate) {
			movebox(index, item._x, item._y, 'wheel', true);
		} else {
			setposition(item, item._x, item._y, 'b');
		}

		if (item.e.s) {
			clearTimeout(item.e.t);
			item.e.t = setTimeout(item.e.s, 75);
		}

		e.preventDefault();

	}

	function removeeventsformove(item) {
		removeevent($html, {
			'mousemove touchmove': item.e.m,
			'mouseup touchend': item.e.u
		});
		enablebodyselect();
	}

	function movebox(index, x, y, moveoptionkey, withoutsnap, withoutanimation) {

		var item = items[index],
			iszoomming = moveoptionkey == 'zoom',
			withoutanimation, movegap;

		if (!withoutsnap) {
			x = snap(item.o.snap, 'x', x || x === 0 ? x : getedgex(item), item.b[0], item.b[2], item.w > item.b[2]);
			y = snap(item.o.snap, 'y', y || y === 0 ? y : getedgey(item), item.b[1], item.b[3], item.h > item.b[3]);
		}
		if (!item.o.outofbounds || iszoomming || moveoptionkey == 'back' || moveoptionkey == 'wheel') {
			x = getedgex(item, true, x);
			y = getedgey(item, true, y);
		}

		movegap = Math.max(Math.abs(x-item.x), Math.abs(y-item.y));

		stopanimation(index);
		item.r = 0;

		if (!item.o.animate || withoutanimation === true || (!iszoomming && item.x == x && item.y == y)) {
			if (iszoomming) {
				item.z = item._z;
			}
			setposition(item, x, y, 'b');
			fireevent(item, 'moveend', x, y);
		} else if (iszoomming) {
			animator.set(item, {x: x, y: y, z: item._z}, moveoption[moveoptionkey]);
		} else {
			if (!moveoptionkey) {
				moveoptionkey = movegap ? 'normal' : 'back';
			}
			if (moveoptionkey != 'back') {
				fireevent(item, 'throw', x, y);
			}
			if (moveoptionkey == 'wheel') {
				moveoption[moveoptionkey].duration = Math.min(750, item.t.min*2);
			} else if (!iszoomming) {
				moveoption[moveoptionkey].duration = Math.max(item.t.min,
					Math.min(item.t.max,
						moveoptionkey == 'back' ? 0 : movegap*5)
					);
			}
			animator.set(item, {x: x, y: y}, moveoption[moveoptionkey]);
		}

	}

	function setscale(index, _scale, percentx, percenty, withoutanimation) {

		var item = items[index],
			bounds = item.b,
			scale = Math.min(item.z_.max, Math.max(item.z_.min, _scale)),
			relatedscale = scale/item._z;

		if (scale == item.z) {
			return false;
		}

		item._z = scale;
		setbounds(item);

		movebox(index,
				(item.x-(percentx || percentx === 0 ? percentx : 0.5)*bounds[4])*relatedscale + bounds[4]/2,
				(item.y-(percenty || percenty === 0 ? percenty : 0.5)*bounds[5])*relatedscale + bounds[5]/2,
			'zoom', false, withoutanimation);

	}

	function setposition(item, x, y, flag, progress) {

		var bounds, transform;

		if (!x && x !== 0) {
			x = item.x;
		}
		if (!y && y !== 0) {
			y = item.y;
		}

		if (flag != 'b') { // 'b' is 'back'
			bounds = item.b;
			item.q = 0;
			if (bounds[0] > x) {
				x = bounds[0]+(x-bounds[0])/2;
				item.q = -1;
			} else if (x > bounds[2]) {
				x = bounds[2]+(x-bounds[2])/2;
				item.q = 1;
			}
			if (bounds[1] > y) {
				y = bounds[1]+(y-bounds[1])/2;
				item.q = item.q == -1 ? -3 : -2;
			} else if (y > bounds[3]) {
				y = bounds[3]+(y-bounds[3])/2;
				item.q = item.q == 1 ? 3 : 2;
			}
			if (flag == 'f' && item.q) { // 'f' is 'flow'
				if (!item.r) {
					item.r = progress;
				}
				if (progress-item.r > 0.05) {
					stopanimation(item.i);
					onanimated.call(items[item.i]);
				}
			}
		}

		if (item.x != x || item.y != y) {
			fireevent(item, 'move', x, y);
		}

		item.x = x;
		item.y = y;

		if (!item.v) {
			if (item.u != 'left-top') {
				if (item.u == 'x-y') {
					transform = 'translate3d('+ x +'px, '+ y +'px, 0) scale3d('+ item.z +','+ item.z +', 1)';
				} else { // x-y-2d
					transform = 'translate('+ x +'px, '+ y +'px) scale('+ item.z +','+ item.z +')';
				}
				item.$t.style[transformname] = transform;
			} else {
				item.$t.style.left = x +'px';
				item.$t.style.top = y +'px';
			}
		}

	}

	function fireevent(item, type, x, y) {

		var eventdata;

		if (item.o['on'+ type]) {

			// all event datas set to from 0, so min value is always 0.
			eventdata = {
				type: type,
				x: item.b[0] == -Infinity ? -x : x-item.b[0],
				y: item.b[1] == -Infinity ? -y : y-item.b[1],
				max: {x: item.b[2]-item.b[0], y: item.b[3]-item.b[1]}
			};

			if (item.w > item.b[2]) {
				eventdata.x = (eventdata.x-eventdata.max.x)*-1;
			}
			if (item.h > item.b[3]) {
				eventdata.y = (eventdata.y-eventdata.max.y)*-1;
			}

			if (type == 'throw') {
				eventdata.x = item.x;
				eventdata.y = item.y;
				eventdata.destination = {
					x: Math.max(item.b[0], Math.min(item.b[2], x))-item.b[0],
					y: Math.max(item.b[1], Math.min(item.b[3], y))-item.b[1]
				};
				if (item.w > item.b[2]) {
					eventdata.destination.x = (eventdata.destination.x-eventdata.max.x)*-1;
				}
				if (item.h > item.b[3]) {
					eventdata.destination.y = (eventdata.destination.y-eventdata.max.y)*-1;
				}
			}

			eventdata.percent = {x: eventdata.x/eventdata.max.x, y: eventdata.y/eventdata.max.y};

			item.o['on'+ type].call(item.$t, eventdata);
		}

	}

	function onanimate(e) {
		setposition(this, e.x, e.y, 'f', e.progress);
	}

	function onanimated(e) {
		if (this.q) { // return to bounds
			movebox(this.i, this.x, this.y, 'back');
		} else {
			fireevent(this, 'moveend', this.x, this.y);
		}
	}

	function onbackanimate(e) {
		setposition(this, e.x, e.y, 'b');
	}

	function onzoomanimate(e) {
		this.z = e.z;
		setposition(this, e.x, e.y, 'b');
	}

	function onbackanimated(e) {
		this.q = false;
		onanimated.call(this);
	}

	function stopanimation(index) {
		animator.stop(items[index]);
	}

	function getedgex(item, round, value) {
		var bounds = item.b,
			x = value || value === 0 ? value : item.x;
		if (round) {
			x = parseInt(x);
		}
		if (bounds[0] > x) {
			x = bounds[0];
		} else if (x > bounds[2]) {
			x = bounds[2];
		}
		return x;
	}

	function getedgey(item, round, value) {
		var bounds = item.b,
			y = value || value === 0 ? value : item.y;
		if (round) {
			y = parseInt(y);
		}
		if (bounds[1] > y) {
			y = bounds[1];
		} else if (y > bounds[3]) {
			y = bounds[3];
		}
		return y;
	}

	function snap(snapper, flag, to, min, max, reversed) {
		var _to;
		if (snapper !== undefined) {
			if (typeof(snapper) == 'number' || isfunction(snapper)) {
				if (reversed) {
					_to = max;
					max = min;
					min = _to;
				}
				to = to-min;
				max = max-min;
				if (typeof(snapper) == 'number') {
					_to = Math.round(to/snapper)*snapper;
				} else {
					_to = snapper(to*-1)*-1;
				}
				if (Math.abs(to-_to) > Math.abs(to-max)) {
					_to = max;
				}
				return _to+min;
			} else if (isarray(snapper)) {
				return snap(snapper[flag == 'x' ? 0 : 1], flag, to, min, max, reversed);
			} else {
				return snap(snapper[flag], flag, to, min, max, reversed);
			}
		}
		return to;
	}

	function snapafterwheel(index) {
		movebox(index, items[index]._x, items[index]._y, 'wheel');
	}

	function createeventhandler(type, target, index) {
		return type == 'move' ? function(e) {
				move.call(target, index, e);
			}
			: type == 'up' ? function(e) {
				up.call(target, index, e);
			}
			: type == 'snapafterwheel' ? function() {
				snapafterwheel.call(target, index);
			}
			: null
	}

	function getcssproperty(item, x, y) {
		return item.u == 'x-y' ? {x: x, y: y} : {left: x, top: y};
	}

	function getindex(target) {
		return parseInt(target.getAttribute(indexdataname));
	}

	function displaybounds(index, bounds, parent) {
		var classname = 'dragable-bounds-indicator-'+ index;
		if (!isoldie) {
			removeme.call(document.querySelector('.'+ classname));
			create('<div class="'+ classname +'" style="position: absolute; left: '+ bounds[0] +'px; top: '+ bounds[1] +'px; width: '+ (bounds[2]-bounds[0]) +'px; height: '+ (bounds[3]-bounds[1]) +'px; border: 1px solid #000; box-sizing: border-box; background: rgba(255, 255, 255, 0.1); z-index: 999; pointer-events: none;" />', parent);
		}
	}

	function create(tag, parent) {
		var element = document.createElement('div');
		element.innerHTML = tag;
		element = element.children[0];
		if (parent) {
			parent.appendChild(element);
		}
		return element;
	}

	function iselement(target) {
		if (target && target.length) {
			return iselement(target[0]);
		}
		return target && target.nodeType && target.nodeType == 1;
	}

	function isarray(target) {
		return target && target.constructor && target.constructor == Array;
	}

	function isobject(target) {
		return $.isPlainObject(target);
	}

	function isfunction(target) {
		return target && target.constructor == Function;
	}

	function removeme() {
		this && this.parentNode && this.parentNode.removeChild(this);
	}

	function getstyle(target, property) {
		return window.getComputedStyle(target, null)[property];
	}

	function setevent(flag, target, pairs) {
		for (var type in pairs) {
			type.split(' ').map(function(current) {
				target[flag +'EventListener'](current, pairs[type], false);
			});
		}
	}

	function addevent(target, pairs) {
		setevent('add', target, pairs);
	}

	function removeevent(target, pairs) {
		setevent('remove', target, pairs);
	}

	function getpoint(e) {
		if (e.touches) {
			e = e.touches[0];
		}
		return [e.pageX || e.clientX, e.pageY || e.clientY];
	}

	function gettime() {
		return new Date().getTime();
	}

	function preventdefault(e) {
		e.preventDefault();
	}

	function returnfalse() {
		return false;
	}


	// support tests for animate
	(function() {

		var div = document.createElement('div'),
			requestanimationframe = 'requestAnimationFrame',
			prefixs = ['Webkit', 'Moz', 'O', 'ms'],
			i, numprefixs = prefixs.length;

		if (div.style[transformname] === undefined) {
			transformname = 'Transform';
			for (i = 0; i < numprefixs; i++) {
				if (div.style[prefixs[i]+transformname] !== undefined) {
					transformname = prefixs[i]+transformname;
					break;
				}
			}
			if ((/^msT/i).test(transformname)) {
				transform3dable = false;
			}
			if (i == numprefixs) {
				transformname = '';
				transformable = transform3dable = false;
			}
		}

		if (!window[requestanimationframe]) {
			requestanimationframe = 'RequestAnimationFrame';
			for (i = 0; i < numprefixs; i++) {
				if (window[prefixs[i]+requestanimationframe] !== undefined) {
					window.requestAnimationFrame = window[prefixs[i]+requestanimationframe];
					window.cancelAnimationFrame = window[prefixs[i] +'CancelAnimationFrame'];
					break;
				}
			}
		}
		if (!window.requestAnimationFrame) {
			window.requestAnimationFrame = (function() {
				var lasttime = 0;
				return function(callback) {
					var currenttime = gettime();
					var timetocall = Math.max(0, 16-(currenttime-lasttime));
					lasttime = currenttime+timetocall;
					return setTimeout(function() { callback(currenttime+timetocall); }, timetocall);
				}
			})();
			window.cancelAnimationFrame = function(id) {
				clearTimeout(id);
			}
		}

		div = null;

	})();


	// simple animator for only set value x/y
	var animator = (function() {

		var tweens = [],

			fps = 60,
			_easing = 'easeOutCubic',

			nowframe = 0,
			totalframes = 0,
			starttime = 0,
			playing = false,

			timer = null,
			timerdelay = 1000/fps,

			easings = {
				easeOutCubic: function(t,b,c,d) {return c*((t=t/d-1)*t*t+1)+b;},
				easeOutQuart: function(t,b,c,d) {return -c*((t=t/d-1)*t*t*t-1)+b;},
				easeInOutCirc: function(t,b,c,d){if((t/=d/2)<1)return -c/2*(Math.sqrt(1-t*t)-1)+b;return c/2*(Math.sqrt(1-(t-=2)*t)+1)+b;}
			};


		function set(target, property, option) {

			var frames = Math.round(fps*option.duration/1000),
				easing = option.easing || _easing,
				tween, p, values = {}, different = false;

			for (p in property) {
				if (target[p] != property[p]) {
					values[p] = getvalues(p, target[p], property[p], frames, easing);
					different = true;
				}
			}

			if (!different) {
				return false;
			}

			stop(target, property);

			tweens.push({
				tg: target,
				vs: values,
				sf: nowframe,
				tf: frames,
				eu: option.onupdate,
				ee: option.onend
			});

			totalframes = Math.max(totalframes, nowframe+frames+fps);

			if ( !playing ) {
				starttime = gettime();
				timer = window.requestAnimationFrame(action);
				playing = true;
			}

		}

		function stop(target) {
			var i = 0, max = tweens.length,
				tween;
			for (; i < max; i++) {
				tween = tweens[i];
				if (tween && tween.tg == target) {
					tweens[i] = null;
				}
			}
		}

		function action() {
			nowframe = Math.floor((gettime()-starttime)/timerdelay);
			if (totalframes > nowframe) {
				setproperties(nowframe);
				timer = window.requestAnimationFrame(action);
			} else {
				window.cancelAnimationFrame(timer);
				setproperties(totalframes);
				nowframe = totalframes = 0;
				tweens = [];
				playing = false;
			}
		}

		function setproperties(step) {

			var tween, mystep, myframes,
				p, i = 0, max = tweens.length;

			for (; i < max; i++) {
				tween = tweens[i];
				if (tween && step >= tween.sf) {
					myframes = tween.tf-1;
					mystep = Math.min(myframes, step-tween.sf);
					if (mystep > -1) {
						tween.eu && tween.eu.call(tween.tg, geteventvalue(tween, 'update', mystep, myframes));
						if (mystep == myframes) {
							tween.ee && tween.ee.call(tween.tg, geteventvalue(tween, 'end', mystep, myframes));
							tweens[i] = null;
						}
					}
				}
			}

		}

		function geteventvalue(tween, type, step, totalstep) {
			var values = tween.vs,
				eventvalue = {type: type, progress: step/totalstep},
				p;
			for (p in values) {
				eventvalue[p] = values[p][step];
			}
			return eventvalue;
		}

		function getvalues(property, from, to, totalframe, easing) {
			var rv = [], gap = to-from, i = 0;
			totalframe--;
			for ( ; i <= totalframe; i++ ) {
				rv.push(easings[easing](i, from, gap, totalframe));
			}
			return rv;
		}

		return {set: set, stop: stop, easings: easings};

	})();

	initialize.animator = animator;

	// 임시. ios가 업데이트 되면서 touchstart에 preventDefault를 주지 않으면 touch이벤트를 막을 수가 없음.
	// 기존에는 touchmove에 주면 됐었는데..
	// 문제는 touchstart에 preventDefault를 하면 click이 막힘..
	// 그래서 click이벤트용 함수를 만들어 임시로 넣음.
	// moved를 touchmove이벤트가 발생하는가 아닌가로 true/false로 처리했더니 windows에서 move 이벤트가 거의 매번 실행되어서... 카운트하도록 변경.
	initialize.handleclick = function($target, handler) {
		var moved = 0;
		addevent($target, {
			touchstart: function(e) {
				moved = 0;
			},
			touchmove: function() {
				moved++;
			},
			touchend: function(e) {
				if (2 > moved) {
					requestAnimationFrame(function() {
						handler.call($target, e);
					});
				}
			}
		})
	}


})();