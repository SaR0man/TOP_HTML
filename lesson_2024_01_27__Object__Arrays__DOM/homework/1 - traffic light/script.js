let red = document.querySelector('.light_red');
let yellow = document.querySelector('.light_yellow');
let green = document.querySelector('.light_green');

function cycle() {
    setTimeout(() => {
        red.style.backgroundColor = '#ff3333';
    }, 0);
    setTimeout(() => {
        yellow.style.backgroundColor = '#ffff66';
    }, 3000);
    setTimeout(() => {
        red.style.backgroundColor = '#663333';
        yellow.style.backgroundColor = '#666633';
        green.style.backgroundColor = '#66ff00';
    }, 4000);
    setTimeout(() => {
        green.style.backgroundColor = '#336633';
    }, 7000);
    setTimeout(() => {
        green.style.backgroundColor = '#66ff00';
    }, 7500);
    setTimeout(() => {
        green.style.backgroundColor = '#336633';
    }, 8000);
    setTimeout(() => {
        green.style.backgroundColor = '#66ff00';
    }, 8500);
    setTimeout(() => {
        yellow.style.backgroundColor = '#ffff66';
        green.style.backgroundColor = '#336633';
    }, 9000);
    setTimeout(() => {
        red.style.backgroundColor = '#ff3333';
        yellow.style.backgroundColor = '#666633';
    }, 10000);
}

cycle();
setInterval(() => {
    cycle();
}, 10 * 1000);

// do {
//     cycle();
// } while(true);