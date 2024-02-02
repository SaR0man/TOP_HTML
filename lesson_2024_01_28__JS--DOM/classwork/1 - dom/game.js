
// let box = document.querySelector('.box');
// let num = 1;
// let size = 10;
// let localLeft = 0;
// let localTop = 0;
// let isLeft = false;
// let isTop = false;

// setInterval(() => {
//     if(!isLeft && localLeft + 150 < window.innerWidth) {
//         localLeft += size;
//         isTop = false;
//     } else if(!isTop && localTop + 150 < window.innerHeight) {
//         localTop += size;
//         isLeft = true;
//     } else if(isLeft && localLeft > 0) {
//         localLeft -= size;
//         isTop = true;
//     } else if(isTop && localTop > 0) {
//         localTop -= size;
//     } else isLeft = false;
//     box.innerText = ++num;
//     box.style.left = `${localLeft}px`;
//     box.style.top = `${localTop}px`;
// }, 100);

let box = document.querySelector('.box');
let num = 1;

function random(min = 0, max = 6) {
    return Math.ceil(Math.random() * (max - min) + min);
}

setInterval(() => {
    box.innerText = ++num;
    box.style.left = `${random(0, (window.innerWidth - 150))}px`;
    box.style.top = `${random(0, (window.innerHeight - 150))}px`;
}, 1000);