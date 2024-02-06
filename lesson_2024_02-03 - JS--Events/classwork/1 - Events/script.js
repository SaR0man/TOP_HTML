// function printPush() {
//     console.log('push!');
// }

// function printMove() {
//     console.log('move!');
// }

// let box = document.querySelector('.box');

// box.onclick = print;

// let box = document.querySelector('.box');

// box.addEventListener('click', ()=>{
//     console.log("click!");
// });
// box.addEventListener('mousemove', printMove);

// let box = document.querySelector('.box');

// box.addEventListener('mousedown', ()=>{
//     box.style.fontSize = '30px';
//     box.style.backgroundColor = 'red';
//     box.style.color = 'white';
//     box.innerText = "click!";
// });

// box.addEventListener('mouseup', ()=>{
//     box.style.fontSize = '50px';
//     box.style.backgroundColor = 'lightgrey';
//     box.style.color = 'black';
//     box.innerText = "1";
// });

// let box = document.querySelector('.box');
// let box2 = document.querySelector('.box2');

// box.addEventListener('click', ()=>{
//     console.log("I'm a gray box");
//     box.style.fontSize = '30px';
//     box.innerText = 'gray';
// })

// box2.addEventListener('click', ()=>{
//     console.log("I'm a yellow box");
//     box2.style.fontSize = '30px';
//     box2.innerText = 'yellow';
//     event.stopPropagation();
// })

// let boxes = document.querySelectorAll(".box");

// for (const box of boxes) {
//     box.addEventListener("click", () => {
//         let num = event.target.innerText;
//         num++;
//         event.target.innerText = num;
//     });
// }


// let container = document.querySelector('.container');
// let box = document.createElement('div');
// box.style.width = '100px';
// box.style.height = '100px';
// box.style.backgroundColor = 'red';
// box.style.margin = '10px';

// container.append(box);

// document.querySelector('button').addEventListener('click', ()=>{
//     let box = document.createElement('div');
//     box.className = 'box';
//     box.innerText = '1';
    
//     container.append(box);
// })
// let container = document.querySelector('.container');

// container.addEventListener("click", () => {
//     console.log(event.target);
//     if(event.target.className == 'box'){
//         let num = event.target.innerText;
//         num++;
//         event.target.innerText = num;
//     }
// });

let box = document.querySelector('.box');
box.addEventListener('click', ()=>{
    event.target.remove();
})
