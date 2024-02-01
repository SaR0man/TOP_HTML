let box = document.querySelector('.box');
let r;
let num = 1;

function random(min = 0, max = 5) {
    r = Math.floor(Math.random() * (max - min) + min);
    r = ((r * 64 - 1));
    if (r < 0) {
        r = 0;
    }
    return r;
}

setInterval(() => {
    console.log(random());
    // box.style.backgroundColor = `rgb(${random()}, ${random()}, ${random()})`;
    box.innerText = ++num;
    box.style.left = `${num * 10}px`;
}, 1000);