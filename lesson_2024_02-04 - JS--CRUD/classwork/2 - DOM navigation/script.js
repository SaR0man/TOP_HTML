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

form.addEventListener("submit", () => {
  event.preventDefault;
});

// form.text.addEventListener('change', ()=>{
//     console.log('change');
// })

// form.text.addEventListener('input', ()=>{
//     console.log('input: ' + event.target.value);
// })

// form.addEventListener('keydown', ()=>{
//     console.log('keydown: ' + event.key);
// })

// form.addEventListener('keyup', ()=>{
//     console.log('keyup: ' + event.key);
// })

// form.addEventListener('keyup', ()=>{
//     console.log('keyup: ' + event.key);
// })

// form.text.addEventListener("keydown", () => {
//   console.log("keydown");
//   if (event.key == "_" || event.key == "@") {
//     event.preventDefault();
//   }
// });

form.text.addEventListener("keydown", () => {
  console.log("keydown");
  if (event.key == "_" || event.key == "@") {
    event.preventDefault();
  }
  for (let index = 0; index < 10; index++) {
    if (event.key == index) {
      event.preventDefault();
    }
  }
});
