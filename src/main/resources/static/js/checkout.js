const checkoutContainer = document.getElementById("checkout-container");
const checkoutTotal = document.getElementById("checkout-total");
const thankYou = document.getElementById("thank-you");

let cart = JSON.parse(localStorage.getItem("cart")) || [];

function renderCheckout() {
    checkoutContainer.innerHTML = "";
    let total = 0;

    cart.forEach(item => {
        total += item.price * item.qty;
        const div = document.createElement("div");
        div.className = "cart-item";
        div.innerHTML = `
            <img src="${item.img}" alt="${item.name}">
            <div>
                <h4>${item.name}</h4>
                <p>₹${item.price} x ${item.qty}</p>
            </div>
        `;
        checkoutContainer.appendChild(div);
    });

    checkoutTotal.innerText = total;
}

renderCheckout();

document.getElementById("place-order").addEventListener("click", () => {
    if(cart.length === 0){
        alert("Your cart is empty!");
        return;
    }
    // Clear cart and show thank you
    localStorage.removeItem("cart");
    checkoutContainer.style.display = "none";
    document.querySelector(".checkout-summary").style.display = "none";
    thankYou.style.display = "block";
});
