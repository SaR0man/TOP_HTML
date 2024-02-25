let arr = [];

function random(min, max) {
    return Math.round(Math.random() * (max - min) + min);
}

function numberPrefix(select) {
    if (select == 1) {
        return "51";
    } else if (select == 2) {
        return "50";
    } else if (select == 3) {
        return "55";
    } else if (select == 4) {
        return "70";
    } else if (select == 5) {
        return "77";
    }
}

let btn = document.querySelector("#myBtn");
let list = document.querySelector(".myList");
let sms = document.querySelector(".sms");

document.forms.myForm.addEventListener("submit", () => {
    event.preventDefault();
    let text = document.querySelector(".myText").value;

    if (text.trim() == "") {
        sms.hidden = false;
        return;
    } else {
        sms.hidden = true;
    }

    let obj = {
      id: Date.now(),
      title: text,
      phone: `+994${numberPrefix(random(1, 6))}-${random(100, 999)}-${random(10, 99)}-${random (10, 99)}`,
      push: random(10, 20)
    }

    arr.push(obj);
    localStorage.setItem("list", JSON.stringify(arr));

    drawItem(obj);

    document.forms.myForm.reset();
});

function drawItem(obj) {
  list.innerHTML += `
  <li class="list-group-item d-flex justify-content-between align-items-start">
    <div class="ms-2 me-auto">
      <div class="fw-bold"><span data-id = "${obj.id}">❌</span>${obj.title}</div>
      Number: ${obj.phone};
    </div>
    <span class="badge bg-primary rounded-pill">${obj.push}</span>
  </li>
`;
}

function deleteObgById (id) {
    arr = arr.filter(item => item.id != id);
    localStorage.setItem("list", JSON.stringify(arr));
}

document.querySelector("#myBtnClear").addEventListener("click", () => {
    list.innerHTML = "";
    localStorage.clear();
    arr = [];
});

list.addEventListener("click", () => {
    if (event.target.tagName == "SPAN") {
        event.target.parentElement.parentElement.parentElement.remove();

        let id = event.target.dataset.id;
        deleteObgById(id);
    }
});

document.addEventListener('DOMContentLoaded', ()=>{
    let str = localStorage.getItem('list');
    if (str) {
        arr = JSON.parse(str);

        for (const item of arr) {
            drawItem(item);
        }
    }
})

// localStorage.clear();
