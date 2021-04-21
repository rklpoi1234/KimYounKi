let t = [99,200,2,6,10,11,22,1,7];
let t2 = t.map((item) => 
{
    return item * 2;    //배열안 요소들을 1대1로 짝지어주는것
});

 console.log(t2); //mapping 한다고합니다

// let myArr = {
//     arr : [99,200,2,6,10,11,22,1,7],
//     map : function(fn) 
//     {
//         let newArr = [];

//         for (let i = 0; i < this.arr.length; i++) {
//            newArr[i] = fn(this.arr[i])
//         }
//         return newArr;
//     }
// }
// let arr3 = myArr.map((item) => 
// {
//     return item * 2;
// });

// console.log('arr : ' +myArr.arr);
// console.log('arr3  : ' +arr3);

let myArr = {
    arr : [10,20,30,40,60],
    Map : function (prop) 
    {
        let myTemp = []; //arr2로 넘어온값을 저장하기위한 배열
        for (let i = 0; i < this.arr.length; i++) {
            //function 파라미터값에 myArr.arr[i]값이들어가면서
            //prop은 예를들어 영번째인덱스값인 10이들어가고
            //아레 함수에의해 그숫자의 2배가됩니다
            //2배가된값을 myTemp배열에 인덱스에 맞춰하나씩들어감
            myTemp[i] = prop(this.arr[i]);
        }
        return myTemp; //최종 리턴을 배열이다담긴 myTemp으로돌려줍니다.
    }
}

let arr2 = myArr.Map((prop) =>
{
    return prop * 2;
});

console.log('myArr:',myArr.arr);
console.log('Arr:',arr2);


//리턴 조건에 맞는 값을 거르는 함수
//지금 식에선 짝수를 리턴하고 홀수를 리턴하지않았습니다.
let arr3 = [99,200,2,6,10,11,22,1,7];
let arr4 = arr3.filter((item) => 
{
    return item % 2 == 0;
});

console.log('arr3 : ' +arr3);
console.log('arr4 : ' +arr4);


let myArr2 = 
{
    arr: [99,200,2,6,10,11,22,1,7],
    filter: function (cb) {
        let newArr =[];
        for (let i = 0; i < this.arr.length; i++) {
            if (cb(this.arr[i])) 
            {   //위처럼 똑같이하면 불리언타입이되어 true,false 나출력이됩니다
                //아까 위에 예제중 짝수 true 홀수 false를 보고 생각해봤는데
                //cd % 2 == 0 값이 트루이면 돌려주고 폴스이면 스킵생각
                //if문을 쓰면 트루일때 불켜지고 펄스일때 꺼짐을이용
                newArr.push(this.arr[i]);
                //이렇게 푸시를하면 정수가 배열에담긴다
            }
            
        }
        return newArr;

    }
}

let result = myArr2.filter((cb) =>
{
    return cb % 2 == 0; //리턴값이 불리언!!!
})

console.log('myArr2:' +myArr2.arr);
console.log('result: ' + result);
