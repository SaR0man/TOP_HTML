// let num = 123.456;

// console.log(Math.round(num));
// console.log(Math.floor(num));
// console.log(Math.ceil(num));

// console.log(num.toFixed(2));

// console.log(Math.random());

// function random(min = 0, max = 6) {
//     return Math.ceil(Math.random() * (max - min) + min);
// }

// console.log(random());

// let num = 1;

// setInterval(() => {
//     console.log(num++ + ') text');
// }, 2 * 1000);

let num = 1;

function interval() {
    console.log(num++ + ') text');
}

setInterval(interval, 2 * 1000);