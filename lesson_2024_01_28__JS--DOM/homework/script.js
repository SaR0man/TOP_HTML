let work = 5000;  // время работы анимации

function selectionColor() {
    let color = prompt("Какой блок выбрать?\n1 - красный\n2 - синий\n3 - зеленый;");
    if (color != 1 && color != 2 && color != 3) {
        alert('Ошибка ввода');
        // selectionColor();
    } else {
        return color;
    }
}

function selectionAction() {
    let action = prompt('Какое действие выбрать?\n1 - Вращение\n2 - Масштабирование\n3 - Смена цвета\n4 - Движение')
    if (action != 1 && action != 2 && action != 3 && action != 4) {
        alert('Ошибка ввода');
    } else {
        return action;
    }
}

function selectionSpeed() {
    let speed = prompt('Введите скорость анимации в милисекундах\n(оптимальное значение ~200):');
    return speed;
}

function rotateBox(speed) {
    let angle = 1;
    // document.getElementById(color).style.transition = speed;
    let id1 = setInterval(() => {
        angle++;
        document.getElementById(color).style.transform = 'rotate(' + angle + 'deg)';
    }, speed / 100);
    setTimeout(() => {
        clearInterval(id1);
    }, work);
}

function scaleBox(speed) {
    let scale = 1;
    let id2 = setInterval(() => {
        scale += 0.1;
        document.getElementById(color).style.transform = 'scale(' + scale + ')';
    }, speed);
    setTimeout(() => {
        clearInterval(id2);
    }, work);
}

function colorBoxOriginal(color) {

    return window
        .getComputedStyle(document.getElementById(color))
        .getPropertyValue('background-color');  // запоминаем оригинальный цвет
}

function colorBox(speed) {
    let ob = document.getElementById(color);

    function random(min = 0, max = 5) {  // случайный цвет с шагом 64 (более чистые цвета)
        r = Math.floor(Math.random() * (max - min) + min);
        r = ((r * 64 - 1));
        if (r < 0) {
            r = 0;
        }
        return r;
    }

    let id3 = setInterval(() => {
        ob.style.backgroundColor = `rgb(${random()}, ${random()}, ${random()})`
    }, speed);
    setTimeout(() => {
        clearInterval(id3);
    }, work);
}

let color = selectionColor();
// console.log(color);
document.getElementById(color).style.border = '5px solid gray';  // обозначаем рамкой выбранный бокс

setTimeout(() => {  // задержка выполнения следующих действий чтобы показать выбранный бокс
let action = selectionAction();
let speed = selectionSpeed();


    
    if (action == 1) {
        rotateBox(speed);

        setTimeout(() => {  // возвращаем бокс в исходное положение и убираем рамку
            document.getElementById(color).style.transition = '0.5s';
            document.getElementById(color).style.border = '2px solid white';
            document.getElementById(color).style.transform = 'rotate(0deg)';
        }, 5500);
    } else if (action == 2) {
        scaleBox(speed);

        setTimeout(() => {  // возвращаем бокс в исходное состояние и убираем рамку
            document.getElementById(color).style.transition = '0.5s';
            document.getElementById(color).style.border = '2px solid white';
            document.getElementById(color).style.transform = 'scale(1)';
        }, 5500);
    } else if (action == 3) {
        let baseColor = colorBoxOriginal(color);
        colorBox(speed);

        setTimeout(() => {  // возвращаем бокс в исходное состояние и убираем рамку
            document.getElementById(color).style.transition = '0.5s';
            document.getElementById(color).style.border = '2px solid white';
            document.getElementById(color).style.backgroundColor = baseColor;
        }, 5500);
    } else if (action == 4) {
        let coordLeft = window.getComputedStyle(document.getElementById(color))
        .getPropertyValue('left');  // запоминаем положение left
        console.log(coordLeft);
        // let num = 1;
        let size = 10;
        let localLeft = 0;
        let localTop = 0;
        let isLeft = false;
        let isTop = false;

        let ob = document.getElementById(color);
        ob.style.left = 0;
        ob.style.top = 0;

        let id4 = setInterval(() => {
            if(!isLeft && localLeft + 150 < window.innerWidth) {
                localLeft += size;
                isTop = false;
            } else if(!isTop && localTop + 150 < window.innerHeight) {
                localTop += size;
                isLeft = true;
            } else if(isLeft && localLeft > 0) {
                localLeft -= size;
                isTop = true;
            } else if(isTop && localTop > 0) {
                localTop -= size;
            } else isLeft = false;
            // ob.innerText = ++num;
            ob.style.left = `${localLeft}px`;
            ob.style.top = `${localTop}px`;
        }, speed / 10);
        setTimeout(() => {
            clearInterval(id4);
        }, work);
        setTimeout(() => {  // возвращаем бокс в исходное положение и убираем рамку
            document.getElementById(color).style.transition = '0.5s';
            document.getElementById(color).style.border = '2px solid white';
            ob.style.left = coordLeft;
            ob.style.top = '200px';
            }, 5500);
    }
    
}, 500);


    
    


