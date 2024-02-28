
let shopList = [];
let list = document.querySelector(".myList");
let btn = document.querySelector("#btnAdd");

// function checkNumber(number) {
//     if (number < 1 )
// }

// Отрисовываем строку с товаром
function drawItem(obj) {
  // list.innerHTML += `
  // <li class="list-group-item d-flex justify-content-between align-items-start p-1">
  //     <div class="myRow ms-2 me-auto">
  //         <div class="fw-bold d-flex justify-content-between">${obj.purchaseName}
  //             <span data-id = "${obj.id}">&#9989;</span>
  //         </div>`
  //           if (obj.purchaseNumber > 0) {
  //             list.innerHTML += `
  //             <div class="fs-6">${obj.purchaseNumber} &nbsp;${obj.purchaseUnit}</div>
  //             `
  //           }
  //           if (obj.purchaseNote != "Комментарий" && obj.purchaseNote.trim != "") {
  //             list.innerHTML += `
  //             <div class="fs-6">${obj.purchaseNote}</div>
  //             `
  //           }
  //           list.innerHTML += "</div></li>";

  list.innerHTML += `<li class="list-group-item d-flex justify-content-between align-items-start p-1">
  <div class="myRow ms-2 me-auto">
    <div class="fw-bold d-flex justify-content-between">${obj.purchaseName} <span data-id="${obj.id}">✅</span></div>
    ${obj.purchaseNumber ? `<div class="fs-6">${obj.purchaseNumber} ${obj.purchaseUnit}</div>` : ''}
    ${obj.purchaseNote === "Комментарий" || obj.purchaseNote.trim == "" ? '' : `<div>${obj.purchaseNote}</div>`}
  </div>  
</li>`;
}

document.forms.groupForm.addEventListener("submit", () => {
    event.preventDefault();
    
    let text = document.querySelector(".purchaseName").value;

    if (text.trim() != "") {
        let number = document.querySelector(".purchaseNumber").value;
        let unit = document.querySelector(".purchaseUnit").value;
        let note = document.querySelector(".purchaseNote").value;

        let obj = {
          id: Date.now(),
          purchaseName: text,
          purchaseNumber: number,
          purchaseUnit: unit,
          purchaseNote: note
        }
        
        shopList.push(obj);
        localStorage.setItem("list", JSON.stringify(shopList));
    
        drawItem(obj);
    
        document.forms.groupForm.reset();
    
    }
});

// удаляем по клику на галочке
list.addEventListener("click", () => {
  if (event.target.tagName == "SPAN") {
      event.target.parentElement.parentElement.parentElement.remove();

      let id = event.target.dataset.id;
      deleteObgById(id);
  }
});

// отображаем список покупок
document.addEventListener('DOMContentLoaded', ()=>{
  let str = localStorage.getItem('list');
  if (str) {
      arr = JSON.parse(str);

      for (const item of arr) {
          drawItem(item);
      }
  }
})

