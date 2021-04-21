<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
   <script>
      let arr = [10,20,30,40,50,60]; //arr1배열선언
      let arr2 = { //arr2 배열선언
          0: 10,
          1: 20,
          2: 30,
          3: 40,
          4: 50,
          5: 60,
          length: 6,
          map:function(item)
          {
              let temp = []; //임시로 저장할수있는 temp배열생선
              for (let i = 0; i < this.length; i++)
              { // arr2[i] = this[i]
                // ex arr2[0]이면 item(10)
                //이고 이걸 val에다 넘겨줌 
                //val의 값을 템배열에다넣고
                //item대신 temp를돌려줌 콜백함수작동
                var val = item(arr2[i]); 
                temp[i] = val;   
              }
              return temp;
          }
      } 
     
      

      let result = arr.map(function (item) 
      { //이미 어디서 선언된 map
          return item * 2;
      });
      let result2 = arr2.map(function (item) 
      {//만들어서 넘겨주는 map
          return item * 2;
      });
      console.log('result : ' + result);
      console.log('result2: ' + result2);
   </script> 
</body>
</html>