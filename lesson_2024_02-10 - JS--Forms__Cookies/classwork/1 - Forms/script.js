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

  list.innerHTML += `
    <li
    class="list-group-item d-flex justify-content-between align-items-start"
  >
    <div class="ms-2 me-auto">
      <div class="fw-bold"><span>❌</span>${text}</div>
      Number: +994${numberPrefix(random(1, 6))}-${random(100, 999)}-${random(10, 99)}-${random(10, 99)};
    </div>
    <span class="badge bg-primary rounded-pill">${random(10, 20)}</span>
  </li>
    `;

  document.querySelector(".myText").value = "";
});

document.querySelector("#myBtnClear").addEventListener("click", () => {
  list.innerHTML = "";
});

list.addEventListener("click", () => {
  if (event.target.tagName == "SPAN") {
    event.target.parentElement.parentElement.parentElement.remove();
  }
});
