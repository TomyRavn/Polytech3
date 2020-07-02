//1.
// console.log('Im working. Im JS. Im Beautiful. Im worth it');

//2.
// const nicoInfo = {
//     name:"Nico",
//     age:33,
//     gender:"Male",
//     isHandsome:true,
//     favMovies:["Along the gods", "LOTR", "Oldboy"],
//     favFood:[
//         {
//             name:"Kimchi",
//             fatty:false
//         },
//         {
//             name:"Cheese burger",
//             fatty:true
//         }
//     ]
// }
// // console.log(nicoInfo.gender);
// console.log(nicoInfo);

//3.
// function sayHello(name, age){
//     console.log(`Hello ${name} you are ${age} years old`);
// }

// sayHello("Nicolas", 15);

//4.
// const calculator = {
//     plus: function(a, b){
//         return a + b;
//     },
//     minus: function(a, b){
//         return a - b;
//     },
//     multiply: function(a, b){
//         return a * b;
//     },
//     divide: function(a, b){
//         return a / b;
//     }
// }

// const plus = calculator.plus(5, 5);
// const minus = calculator.minus(5, 5);
// const multiply = calculator.multiply(5, 5);
// const divide = calculator.divide(5, 5);
// console.log(plus);
// console.log(minus);
// console.log(multiply);
// console.log(divide);

//5.
// // const title = document.getElementById("title");
// // const title = document.querySelector(".title");
// const title = document.querySelector("#title");
// title.innerHTML = "Hi! From JS";
// title.style.color = "blue";
// console.dir(title);
// document.title = "I own you now";

//6.
// const title = document.querySelector("#title");
// const BASE_COLOR = "white";
// const OTHER_COLOR = "red";

// function handleClick(){
//     const currentColor = title.style.color;
//     if(currentColor == BASE_COLOR){
//         title.style.color = OTHER_COLOR;
//     }else{
//         title.style.color = BASE_COLOR;
//     }
// }

// function init(){
//     title.style.color = BASE_COLOR;
//     title.addEventListener("click", handleClick);
// }

// init();

//7.
const title = document.querySelector("#title");

const CLICKED_CLASS = "clicked";

function handleClick(){
    const currentClass = title.className;
    if(currentClass != CLICKED_CLASS){
        title.className = CLICKED_CLASS;
    }else{
        title.className = "";
    }
}

function init(){
    title.addEventListener("click", handleClick);
}
init();