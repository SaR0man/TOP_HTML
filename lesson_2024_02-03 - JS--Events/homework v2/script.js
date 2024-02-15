let speed = 1000;
let timer = 30;
let count = 9;

alert('Дается ' + timer + ' секунд.\nЗа это время нужно успеть кликнуть по всем кругляшам')

let tablo = document.querySelector('.tablo');
tablo.innerHTML = 'timer: ' + timer + '; left: ' + count;

let myContainer = document.querySelector(".container");

for (let index = 0; index < count; index++) {
  myContainer.innerHTML += `<div class="box">🤍</div>`;
}

// случайный цвет с шагом 64 (более чистые цвета)
function randomColor(min = 0, max = 5) {
  r = Math.floor(Math.random() * (max - min) + min);
  r = r * 64 - 1;
  if (r < 0) {
    r = 0;
  }
  return r;
}

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min)) + min;
}

let boxes = document.querySelectorAll(".box");
boxes.forEach((box) => {
  box.style.backgroundColor = `rgb(${randomColor()}, ${randomColor()}, ${randomColor()})`
  box.style.position = "absolute";

  let top = getRandomInt(0, window.innerHeight - box.offsetHeight);
  let left = getRandomInt(0, window.innerWidth - box.offsetWidth);

  box.style.top = `${top}px`;
  box.style.left = `${left}px`;
});

let id_1 = setInterval(() => {
    timer -= 1;
    tablo.innerHTML = 'timer: ' + timer + '; left: ' + count;

    for (const box of boxes) {
        let top = getRandomInt(0, window.innerHeight - box.offsetHeight);
        let left = getRandomInt(0, window.innerWidth - box.offsetWidth);
      
        box.style.top = `${top}px`;
        box.style.left = `${left}px`;
    }

    if (timer == 0 || count == 0) {
        clearInterval(id_1);
        alert('Game over!')
    }

}, speed);


document.addEventListener('click', ()=>{
    if(event.target.className === 'box') {
        count -= 1;
      event.target.remove();
    }
  });
  
