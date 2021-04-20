'use strict' //엄격모드

    //    var val_1 = '10';
    //    var val_2 = 10;

    //    console.log(val_1 + val_2);
    //    console.log(val_1 * val_2);
    //    console.log(val_1 - val_2);
    //    console.log(val_1 / val_2);
    //    console.log(val_1 % val_2);
    //    console.log(parseInt(val_1) + val_2);
    //    console.log(Number(val_1) + val_2);


    // if (-2) {
    //     console.log('-2 true');
    // }if (0) {
    //     console.log('0true');
    // }else {
    //     console.log('0 false')
    // }


    // if ('a') {
    //    console.log('true'); 
    // } else {
    //    console.log('false');
    // }

    // var result = 10 || 20 || 12;
    // var result2 = 10 && 20 && 12;
    // console.log(result)
    // console.log(result2)

    // for (let i = 2; i < 10; i++) {
    //    for (let j = 1; j < 10; j++) {
    //       console.log('%d %d = %d ',i,j,i*j); 
    //    } 
    // }

    // function sum(n1,n2) {
    //    return n1+n2; 
    // }
    // var result = sum(19,20);
    // console.log('%s %d ','result',result);

    // function calc(sum,n1,n2) {
    //    return sum(n1,n2); 
    // }

    // function sum(n1,n2) {
    //    return n1 + n2;
    // }
    // console.log(calc(sum,10,20))

    // var boj = {
    //     name : 'hongkildong',
    //     age: 30,
    //     run: function(){
    //         console.log('%s run',name);
    //     }
    // };
    // boj.name = 'hani';
    // console.log(boj)
    // boj.run();
    // boj.run = 30;
    // console.log(boj);

  // let arr = [1,2,3,4,5,6,7,8,9];


//     console.log(arr[1]);
//     console.log(arr.length);

//     arr.length = 3;
//     arr[3]= 10;
//   console.log(arr); 



//    function print(item) {
//        console.log('item: ' + item);
//    }

    let arr2 = [10,20,30,40,50];

    var result = arr2.map(function (itme) {
        if (itme >= 30) {
            
            return itme * 2;
        } else {
            return itme
        }
    });

    function myMap(itme) {
        return itme + 1;
        
    }
    var result2 = arr2.map(myMap);

    console.log('result : ' +result);
    console.log('arr2 : ' + arr2);
    console.log(result2);
 