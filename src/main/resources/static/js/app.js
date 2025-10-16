const api = '/api';

async function fetchProducts(filters = {}) {
  const params = new URLSearchParams(filters);
  const resp = await fetch(`${api}/products?${params.toString()}`);
  return resp.json();
}

function buildCard(product) {
  const div = document.createElement('div');
  div.className = 'card';
  if(product.badge) {
    const b = document.createElement('div');
    b.className = 'badge';
    b.innerText = product.badge;
    div.appendChild(b);
  }
  const heart = document.createElement('div');
  heart.className = 'heart';
  heart.innerHTML = '♡';
  div.appendChild(heart);

  const img = document.createElement('div');
  img.className = 'product-image';
  img.innerHTML = `<div style="font-weight:600">${product.name.split(' ').slice(0,2).join(' ')}</div>`;
  div.appendChild(img);

  const title = document.createElement('h4');
  title.innerText = product.name;
  div.appendChild(title);

  const cat = document.createElement('div');
  cat.style.color = '#6b7280';
  cat.style.fontSize = '13px';
  cat.innerText = product.category;
  div.appendChild(cat);

  const price = document.createElement('div');
  price.className = 'price';
  price.innerText = `$${product.price.toFixed(2)}`;
  div.appendChild(price);

  const row = document.createElement('div');
  row.className = 'btn-row';
  const buy = document.createElement('button');
  buy.className = 'buy-btn';
  buy.innerText = `Buy $${product.price.toFixed(2)}`;
  buy.onclick = () => addToCart(product.id);
  const icon = document.createElement('button');
  icon.className = 'icon-btn';
  icon.innerHTML = '🛒';
  icon.onclick = () => addToCart(product.id);
  row.appendChild(buy);
  row.appendChild(icon);
  div.appendChild(row);

  return div;
}

async function renderProducts(filters) {
  const grid = document.getElementById('productGrid');
  if(!grid) return;
  grid.innerHTML = '';
  const products = await fetchProducts(filters);
  products.forEach(p => grid.appendChild(buildCard(p)));
  populateFilterOptions(products);
}

function populateFilterOptions(products) {
  const cat = document.getElementById('filter-category');
  const brand = document.getElementById('filter-brand');
  const color = document.getElementById('filter-color');
  if(!cat) return;

  const cats = [...new Set(products.map(p=>p.category))];
  const brands = [...new Set(products.map(p=>p.brand))];
  const colors = [...new Set(products.map(p=>p.color))];

  if(cat.options.length <= 1){
    cats.forEach(c => {
      const o = document.createElement('option'); o.value = c; o.innerText = c; cat.appendChild(o);
    });
  }
  if(brand.options.length <= 1){
    brands.forEach(b => {
      const o = document.createElement('option'); o.value = b; o.innerText = b; brand.appendChild(o);
    });
  }
  if(color.options.length <= 1){
    colors.forEach(c => {
      const o = document.createElement('option'); o.value = c; o.innerText = c; color.appendChild(o);
    });
  }
}

async function addToCart(productId) {
  await fetch(`${api}/cart/add`, {
    method:'POST',
    headers:{'Content-Type':'application/json'},
    body: JSON.stringify({productId, quantity:1})
  });
  alert('Added to cart');
}

async function loadCartPage() {
  const resp = await fetch(`${api}/cart`);
  const data = await resp.json();
  const itemsDiv = document.getElementById('cartItems');
  if(!itemsDiv) return;
  itemsDiv.innerHTML = '';
  data.items.forEach(it => {
    const div = document.createElement('div'); div.className = 'cart-item';
    const mini = document.createElement('div'); mini.className = 'mini';
    mini.innerText = it.product.name.split(' ').slice(0,2).join(' ');
    div.appendChild(mini);
    const info = document.createElement('div');
    info.innerHTML = `<div><strong>${it.product.name}</strong></div>
                      <div>${it.quantity} × $${it.product.price.toFixed(2)}</div>
                      <div>Subtotal: $${it.subtotal.toFixed(2)}</div>`;
    div.appendChild(info);

    const remove = document.createElement('button'); remove.className='icon-btn'; remove.innerText='Remove';
    remove.onclick = async () => {
      await fetch(`${api}/cart/remove`, {
        method:'POST',
        headers:{'Content-Type':'application/json'},
        body: JSON.stringify({productId: it.product.id})
      });
      await loadCartPage();
    };
    div.appendChild(remove);
    itemsDiv.appendChild(div);
  });
  document.getElementById('cartTotal').innerText = data.total.toFixed(2);
}

async function checkout() {
  const resp = await fetch(`${api}/cart/checkout`, { method:'POST' });
  const data = await resp.json();
  if(data.message) {
    window.location.href = '/checkout.html';
  }
}

// Hooks for pages
document.addEventListener('DOMContentLoaded', () => {
  if(document.getElementById('productGrid')) {
    renderProducts({});
    document.getElementById('applyFilters').onclick = () => {
      const filters = {};
      const cat = document.getElementById('filter-category').value;
      const brand = document.getElementById('filter-brand').value;
      const color = document.getElementById('filter-color').value;
      const min = document.getElementById('minPrice').value;
      const max = document.getElementById('maxPrice').value;
      const instock = document.getElementById('filter-instock').checked;
      if(cat) filters.category = cat;
      if(brand) filters.brand = brand;
      if(color) filters.color = color;
      if(min) filters.minPrice = min;
      if(max) filters.maxPrice = max;
      if(instock) filters.inStock = true;
      renderProducts(filters);
    };
    document.getElementById('clearFilters').onclick = () => {
      document.getElementById('filter-category').value = '';
      document.getElementById('filter-brand').value = '';
      document.getElementById('filter-color').value = '';
      document.getElementById('minPrice').value = '';
      document.getElementById('maxPrice').value = '';
      document.getElementById('filter-instock').checked = false;
      renderProducts({});
    };
  }

  if(document.getElementById('cartItems')) {
    loadCartPage();
    document.getElementById('checkoutBtn').onclick = checkout;
  }
});
