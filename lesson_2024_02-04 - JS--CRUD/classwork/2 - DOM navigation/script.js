// let btns = document.querySelectorAll('a');

// for (const btn of btns) {
//     btn.addEventListener('click', ()=>{
//         event.target.parentElement.previousElementSibling.src = './img/Oracle_logo.svg.png'
//     })
// }

// parentElement;
// children;
// firstElementChild;
// lastElementChild;
// previousElementSibling;
// nextElementSibling;

///////////////////////////////////////////////////

// let form = document.querySelector('#textForm');

let form = document.forms.myForm;

form.addEventListener('submit', ()=>{
    // alert('Hello world!');

    event.preventDefault;
})

// form.addEventListener('change', ()=>{
//     console.log('change');
// })

form.addEventListener('input', ()=>{
    console.log('input: ' + event.target.value);
})




