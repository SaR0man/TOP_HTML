let localTop = 0;
let speed = 1000;
let distance = 1;
let container_inner = document.querySelector('.container_inner');

function createBox(id) {
    let newElement = document.getElementById(id);
    newElement.innerHTML += '<div class="box">5</div>';
    newElement.style.localTop = 0;
    // let newBox = document.createElement('div');
    // newBox.className = 'box';
    // newBox.innerText = '5';

    container_inner.append();
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
            event.target.remove();
            createBox(id);
        } else {
            size -= 15;
            event.target.innerText = num;
            event.target.style.width = size + 'px';
            event.target.style.height = size + 'px';
        }
    }
})

setInterval(() => {
    let boxes = document.querySelectorAll(".box");
    for (const box of boxes) {
        // window.getComputedStyle(box).getPropertyValue('top');  // 
        // let computedStyle = window.getComputedStyle(box);
        let computedStyle = window.getComputedStyle(box);  //;
        let h = computedStyle.style.top;
        // console.log(computedStyle);
        let position = computedStyle;
        console.log(h);
        localTop = localTop + distance;
        box.style.top = `${position}px`;
    }
}, speed);
