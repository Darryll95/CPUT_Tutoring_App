const bookBtn = document.getElementById("BookBtn");
const date = document.getElementById("selectDate");
const msg = document.querySelector(".bookMsg");

bookBtn.addEventListener("click", () => {
    let moduleSelected = document.querySelector("input[name='module']:checked");
    let studyModule = moduleSelected.value;
    const checkedBtn = document.querySelector("input[name='time']:checked");
    let radiobtn = checkedBtn.value;
    let xDate = new Date(date.value).toLocaleDateString();
    msg.innerHTML = `Session successfully booked for ${studyModule} on ${xDate} at ${radiobtn}`
})

