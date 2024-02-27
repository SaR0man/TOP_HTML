
// function checkNumber(number) {
//     if (number < 1 )
// }

document.forms.groupForm.addEventListener("submit", () => {
    event.preventDefault();
    
    if (text.trim() != "") {
        let text = document.querySelector(".purchaseName").value;
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
        
    }
});
