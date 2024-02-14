let localTop = 0;
let speed = 1000;
let distance = 1;
let container_inner = document.querySelector('.container_inner');

function createBox(id) {
    let newElement = document.getElementById(id);
    console.log(newElement);
    let go = newElement.firstElementChild;
    go.style.top = 0;
    // go.style.width = 100 +'px';
    // go.style.height = 100 + 'px';
    go.innerText = '5';

    // newElement.innerHTML += '<div class="box">5</div>';
    // newElement.style.localTop = 0;
    // container_inner.append();
}

let container = document.querySelector('.container_outer');

container.addEventListener('click', ()=>{
    if(event.target.className == 'box') {
        let num = event.target.innerText;
        let size = event.target.offsetWidth;
        num--;
        if (num == 0) {
            let id = event.target.parentNode.id;
            // console.log(id);
            // event.target.remove();
            createBox(id);
        } else {
            size -= 15;
            event.target.innerText = num;
            // event.target.style.width = size + 'px';
            // event.target.style.height = size + 'px';
        }
    }
})

// setInterval(() => {
//     let boxes = document.querySelectorAll(".box");
//     for (const box of boxes) {
//         // window.getComputedStyle(box).getPropertyValue('top');  // 
//         // let computedStyle = window.getComputedStyle(box);
//         let computedStyle = window.getComputedStyle(box);  //;
//         console.log(computedStyle);
//         let h = computedStyle.style.top;
//         console.log('computedStyle: ' + computedStyle);
//         let position = computedStyle;
//         console.log(h);
//         localTop = localTop + distance;
//         box.style.top = `${position}px`;
//     }
// }, speed);

const boxes = document.querySelectorAll('.box');

for (const box of boxes) {
    // console.log('hello world!');
    let top = 0;
    setInterval(() => {

        let currentTop = box.getBoundingClientRect().top;
        // console.log(currentTop);

        top = currentTop + 10;
        // console.log(`top: ${top}`);
        box.style.top = `${top}px`;

    }, speed);
}
