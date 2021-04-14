'use strict';

// Array

//1. Declartion
const arr1 = new Array();
const arr2 = [1,2];

//2. Index position
const fruits = ['apple','banana'];

//3. Looping over an array
//print all fruits
//a.for
for (let i = 0; i < fruits.length; i++) {
    console.log(fruits[i]);
    
}

//b. for of

for (let fruit of fruits) {
    console.log(fruits);
}