// let btn = document.querySelector('#addBtn');
// let list = document.querySelector('#lists');

// btn.addEventListener('click', ()=>{
//     let text = prompt('Please enter text:');
//     let li = document.createElement('li');
//     li.innerText = text;
//     li.style.color = 'red';

//     let firstLi = document.querySelector('#lists > li li');

//     firstLi.after(li);
// })

let btn = document.querySelector("#myBtn");
let list = document.querySelector(".myList");

btn.addEventListener("click", () => {
  let text = document.querySelector(".myText").value;
  list.innerHTML += `
    <li
    class="list-group-item d-flex justify-content-between align-items-start"
  >
    <div class="ms-2 me-auto">
      <div class="fw-bold">${text}</div>
      Content for list item
    </div>
    <span class="badge bg-primary rounded-pill">${random(10,20)}</span>
  </li>
    `;
});
