// ------------------- CHECKOUT PAGE -------------------
document.addEventListener('DOMContentLoaded', () => {
  const checkoutContainer = document.getElementById('checkout-container');
  const checkoutTotal = document.getElementById('checkout-total');
  const placeOrderBtn = document.getElementById('place-order');
  const thankYou = document.getElementById('thank-you');

  // Load cart from localStorage
  let cart = JSON.parse(localStorage.getItem('cart')) || [];

  function renderCheckout() {
    checkoutContainer.innerHTML = '';
    let total = 0;

    if (cart.length === 0) {
      checkoutContainer.innerHTML = '<p style="text-align:center; color:#7f8c8d;">Your cart is empty 🛒</p>';
      checkoutTotal.textContent = '0';
      placeOrderBtn.disabled = true;
      return;
    }

    cart.forEach(item => {
      total += item.price * item.qty; // Using qty instead of quantity to match localStorage
      const div = document.createElement('div');
      div.className = 'cart-item';
      div.innerHTML = `
        <div style="display:flex; align-items:center; gap:15px;">
          <img src="${item.img}" alt="${item.name}" style="width:80px; height:80px; object-fit:cover; border-radius:5px;">
          <div>
            <h4 style="margin:0;">${item.name}</h4>
            <p style="margin:5px 0;">₹${item.price} × ${item.qty}</p>
          </div>
        </div>
        <p>₹${item.price * item.qty}</p>
      `;
      checkoutContainer.appendChild(div);
    });

    checkoutTotal.textContent = total.toFixed(2);
    placeOrderBtn.disabled = false;
  }

  renderCheckout();

  // Place order button
  placeOrderBtn.addEventListener('click', () => {
    if (cart.length === 0) return;
    localStorage.removeItem('cart'); // clear cart
    cart = [];
    checkoutContainer.style.display = 'none';
    document.querySelector('.checkout-summary').style.display = 'none';
    thankYou.style.display = 'block';
  });
});
