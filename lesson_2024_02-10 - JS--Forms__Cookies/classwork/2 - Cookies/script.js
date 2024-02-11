
let body = document.querySelector('body');
let h2 = document.querySelector('h2');

document.querySelector('#lightBtn').addEventListener('click', ()=>{
  body.style.backgroundColor = 'lightGray';
  h2.style.color = 'black';
  document.cookie = 'theme=Light,color=black;max-age=10';
})

document.querySelector('#darkBtn').addEventListener('click', ()=>{
  body.style.backgroundColor = 'Gray';
  h2.style.color = 'white';
  document.cookie = 'theme=Dark,color=white;max-age=10';
})

document.addEventListener('DOMContentLoaded', ()=>{
  let theme = document.cookie;
  if (theme != '') {
    let color = theme.split(',')[1].split('=')[1];
    let backColor = theme.split(',')[0].split('=')[1];
    
    h2.style.color = color;
    
    if (backColor == 'Light') {
      body.style.backgroundColor = 'lightGray';
    } else if (backColor == 'Dark') {
      body.style.backgroundColor = 'Gray';
    }
  }
})