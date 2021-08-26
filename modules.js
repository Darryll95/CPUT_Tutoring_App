const namefield = document.getElementById("modules");
const bookBtn = document.getElementById("BookBtn");
// const checkedBtn = document.querySelector("input[name='time']:checked");
const date = document.getElementById("selectDate");
const msg = document.querySelector(".bookMsg");


bookBtn.addEventListener("click", () => {
    let temp = namefield.value;

    const checkedBtn = document.querySelector("input[name='time']:checked");
    let radio = checkedBtn.value;
    let xDate = new Date(date.value);

    msg.innerHTML = `Session successfully booked for ${temp} on ${xDate} at ${radio}`
    



})

