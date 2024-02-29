
let shopList = [];
let list = document.querySelector(".myList");
let btn = document.querySelector("#btnAdd");

//// Отрисовываем строку с товаром
function drawItem(obj) {
  list.innerHTML += `<li class="list-group-item d-flex justify-content-between align-items-start p-1">
  <div class="myRow ms-2 me-auto">
    <div class="fw-bold d-flex justify-content-between">${obj.purchaseName} <span data-id="${obj.id}">✅</span></div>
    ${obj.purchaseNumber ? `<div class="fs-6">${obj.purchaseNumber} ${obj.purchaseUnit}</div>` : ''}
    ${obj.purchaseNote === "Комментарий" || obj.purchaseNote.trim == "" ? '' : `<div>${obj.purchaseNote}</div>`}
  </div>  
</li>`;
}

//// отправка введенных данных в новый объект; его запись в массив
document.forms.groupForm.addEventListener("submit", () => {
    event.preventDefault();
    
    let text = document.querySelector(".purchaseName").value;

    if (text.trim() != "") {
        let number = document.querySelector(".purchaseNumber").value;
        let unit = document.querySelector(".purchaseUnit").value;
        let note = document.querySelector(".purchaseNote").value;

        // создаем объект:
        let obj = {
          id: Date.now(),
          purchaseName: text,
          purchaseNumber: number,
          purchaseUnit: unit,
          purchaseNote: note
        }
        
        shopList.push(obj);  // добавляем объект в массив
        
        // перезаписываем массив в localStorage:
        localStorage.setItem("list", JSON.stringify(shopList));  
    
        drawItem(obj);  // отрисовываем объект
    
        document.forms.groupForm.reset();  // сбрасываем содержимое полей ввода
    }
});

//// удаляем по клику на галочке
list.addEventListener("click", () => {
  if (event.target.tagName == "SPAN") {
      event.target.parentElement.parentElement.parentElement.remove();

      let id = event.target.dataset.id;
      deleteObgById(id);
  }
});

//// удаление объекта из массива по id
function deleteObgById (id) {
  shopList = shopList.filter(item => item.id != id);
  localStorage.setItem("list", JSON.stringify(shopList));
}

//// полная очистка
document.querySelector("#btnClr").addEventListener("click", () => {
  list.innerHTML = "";   // списка на веб-странице
  localStorage.clear();  // очистка localStorage
  shopList = [];         // очистка массива
});


//// считываем список с массива shopList в locakStorage и отображаем список покупок 
document.addEventListener('DOMContentLoaded', ()=>{
  let str = localStorage.getItem('list');
  if (str) {
    shopList = JSON.parse(str);

      for (const item of shopList) {
          drawItem(item);
      }
  }
})

//// сбрасываем текст по умолчанию в поле с единицами измерения
document.querySelector('.purchaseUnit').addEventListener('click', ()=>{
  document.querySelector('.purchaseUnit').value = '';
})

//// сбрасываем текст по умолчанию в поле с комментарием
document.querySelector('#floatingTextarea').addEventListener('click', ()=>{
  document.querySelector('#floatingTextarea').value = '';
})
