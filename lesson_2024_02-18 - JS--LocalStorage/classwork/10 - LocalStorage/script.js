function random(min = 0, max = 255) {
    const minCeiled = Math.ceil(min);
    const maxFloored = Math.floor(max);
    return Math.floor(Math.random() * (maxFloored - minCeiled) + minCeiled); // The maximum is exclusive and the minimum is inclusive
}


let arr = [];

let btn = document.querySelector('#myBtn'); //button
let list = document.querySelector(".myList"); //ol
let sms = document.querySelector(".sms"); //ol

function numberPrefix(select) {
    if (select == 1) {
        return '51'
    } else if (select == 2) {
        return '50'
    } else if (select == 3) {
        return '55'
    } else if (select == 4) {
        return '70'
    } else if (select == 5) {
        return '77'
    }
}
// let count = 1;

document.forms.myForm.addEventListener('submit', function() {
    event.preventDefault();

    let text = document.querySelector('.myText').value; // input.value (text)


    if (text.trim() == '') {
        sms.hidden = false;
        return;
    } else {
        sms.hidden = true;
    }


    let toDo = {
        id: Date.now(),
        title: text,
        push: random(10, 30),
        phone: `+994${numberPrefix(random(1,6))}-${random(100,999)}-${random(10,99)}-${random(10,99)}`,
    };

    arr.push(toDo);
    localStorage.setItem("list", JSON.stringify(arr));

    // let str = localStorage.getItem("list");
    // str += "," + text;
    // localStorage.setItem("list", str);

    drawItem(toDo);

    document.forms.myForm.reset();

});


function drawItem(toDo) {
    list.innerHTML += `
    <li class="list-group-item d-flex justify-content-between align-items-start">
    <div class="ms-2 me-auto">
        <div class="fw-bold"> <span>❌</span> ${toDo.title} </div>
       Number : ${toDo.phone} 
    </div>
    <span class="badge bg-primary rounded-pill"> ${toDo.push} </span>
    </li>
    `
}



document.querySelector('#myBtnClear').addEventListener('click', () => {
    list.innerHTML = '';
    localStorage.clear();
});



list.addEventListener('click', () => {
    console.log(event.target);
    if (event.target.tagName == 'SPAN') {
        event.target.parentElement.parentElement.parentElement.remove();

        ///////////////////////////////////////////////////////////////

        let id = event.target.id;
        console.log(id);
    }
})

function deleteObjectById(toDo) {
    arr = arr.filter(x => x.id != toDo.id);
    localStorage.setItem("list", JSON.stringify(arr));
}


document.addEventListener('DOMContentLoaded', () => {
    let str = localStorage.getItem("list");
    if (str) {
        arr = JSON.parse(str);
        console.log(arr);


        for (const item of arr) {
            drawItem(item);
        }
    }
})


// // localStorage.setItem("Farid", "Abdullayev");
// // let value = localStorage.getItem("Farid");
// // console.log(value);
// // localStorage.clear();
// // localStorage.removeItem("Farid");
// // console.log(value);