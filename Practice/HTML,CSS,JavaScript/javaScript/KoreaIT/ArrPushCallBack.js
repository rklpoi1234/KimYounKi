// let arr = []; 
// arr.push(10);
// arr.push(20);
// arr.push(30);
// arr.push(40);
// // arr.shift();
// // arr.shift();

// arr.unshift(11);
// arr.unshift(12);

// console.log(arr);

// let delVal = arr.splice(2,2);
// console.log(delVal);

// let arr = [1,2,3,4,5,6,7,8];

// let result = arr.filter((item)=>
// {   //홀수는 담고 짝수는 안담게
//     if(item % 2 == 1){
//         // console.log(item);
//         return true;
    
//     } else {
//         // console.log(item)
//         return false;
//     }
// })

// function filter(item) {
//    return item % 2; 
// // }

// //console.log(result);

// let arr2 = 
// {
//     0: 10,
//     1: 20,
//     2: 30,
//     3: 40,
//     4: 50,
//     5: 60,
//     6: 70,
    
//     length:8,
//     filter: function(fn)
//     {
//         let temp = [];
//         for (let i = 0; i < this.length; i++) 
//         {
//             if(fn(this[i]))
//             {
//                 temp.push(this[i]);
//             }
//         }
//         return temp;
//     }
// }

// let result2 = arr2.filter(function(item)
// {
//     return item % 2;
// });

// console.log(arr2);
// console.log('result2 : ' + result2);

// function sum(n1) {
//     if (n1 == undefined) {
//         n1 = 10;
        
//     }
//     console.log(n1);
    
// }

// sum(30);

// sumAll(1);
// sumAll(1,5);
// sumAll(1,5,4);
// sumAll(1,5,4,5);

// function sumAll(...n1) {
//     let sum = 0;
//     for (let i = 0; i < arguments.length; i++) {
//         sum += n1[i]
//     }
//     console.log('sum2 : ' + sum);
// }

// function sumAll(...m1) {
//     let sum = 0;
//     for(let i =0; i<arguments.length ; i++)
//     {
//         sum += m1[i];
//     }
//     console.log(sum);
    
// }
// let val =10;
// setTimeout(()=>
// {
//     console.log(3);
//     val = 100;
// },3000)

// console.log(val);

// setTimeout(() => 
// {
//     console.log(1);
//     setTimeout(() => 
//     {
//         console.log(3)

//         setTimeout(() => 
//         {
//             console.log(5);
//         },1000);
    
//     }, 3000);

// },5000); //callbackhell

// let prom = new Promise((resolve,reject) =>
// {
//     setTimeout(() => 
//     {
//         // 
//         resolve(1);
//     },1000)
// })

function foo() {
    return new Promise((resolve)=>
    {
        setTimeout(()=>
        {
            console.log('foo ok');
            resolve();
        },3000);
    });
    
}

function bar() {
    return new Promise((resolve) => 
    {
        setTimeout(() => 
        {
            console.log('bar ok');
            resolve();    
        }, 2000);   
    });
}

// foo().then(() => 
// {
//     return bar();
// })

async function run()
{
    await foo();
    await bar();
}

run();