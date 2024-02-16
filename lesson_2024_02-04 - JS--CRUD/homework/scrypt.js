
document.forms.testForm.addEventListener('submit', ()=>{
    event.preventDefault();
    let text = document.querySelector(".textField");
    let textBold = document.querySelector('#textBold');
    let textUnderline = document.querySelector('#textUnderline');
    let textItalic = document.querySelector('#textItalic');

    if (textBold.checked) {
        text.style.fontWeight = '900';
    } else {
        text.style.fontWeight = 'normal';
    }

    if (textUnderline.checked) {
        text.style.textDecoration = 'underline';
    } else {
        text.style.textDecoration = 'none';
    }

    if (textItalic.checked) {
        text.style.fontStyle = 'italic';
    } else {
        text.style.fontStyle = 'normal';
    }

    const radios = document.querySelectorAll('input[name="alignment"]');
    for (let i = 0; i < radios.length; i++) {
      const radio = radios[i];
      if (radio.checked) {
        if (radio.id == 'textLeft') {
            text.style.textAlign = 'left';
        } else if (radio.id == 'textRight') {
            text.style.textAlign = 'right';
        } else if (radio.id == 'textJustify') {
            text.style.textAlign = 'justify';
        }
      }
    }
});