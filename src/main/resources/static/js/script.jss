// -------------------- Password Reveal --------------------
const eyeBtn = document.getElementById('eye-btn');
const passwordInput = document.getElementById('password');

if (eyeBtn && passwordInput) {
  eyeBtn.addEventListener('click', () => {
    const origType = passwordInput.type;
    passwordInput.type = 'text';
    setTimeout(() => {
      passwordInput.type = origType;
    }, 500); // reveal for 0.5s
  });
}

// -------------------- Login Validation --------------------
const usernameInput = document.getElementById('username');
const loginBtn = document.getElementById('login-btn');
const msgDiv = document.getElementById('login-msg');

// Password rule: min 8, uppercase, lowercase, number, special char
const passRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

if (loginBtn) {
  loginBtn.addEventListener('click', () => {
    const user = usernameInput.value.trim();
    const pass = passwordInput.value;

    msgDiv.textContent = '';
    msgDiv.className = 'msg';

    if (!user || !pass) {
      msgDiv.textContent = 'Username and password required!';
      msgDiv.classList.add('error');
      return;
    }

    if (!passRegex.test(pass)) {
      msgDiv.textContent = 'Password must be 8+ chars and include uppercase, lowercase, number & special char.';
      msgDiv.classList.add('error');
      return;
    }

    // Save logged user
    localStorage.setItem('loggedUser', user);

    // Initialize user profile if not exists
    const profileKey = `userProfile_${user}`;
    if (!localStorage.getItem(profileKey)) {
      localStorage.setItem(profileKey, JSON.stringify({ firstName: user }));
    }

    msgDiv.textContent = 'Logged in successfully! Redirecting...';
    msgDiv.classList.add('success');

    setTimeout(() => {
      window.location.href = 'index.html';
    }, 600);
  });
}

// -------------------- Enter key submission --------------------
[usernameInput, passwordInput].forEach(el => {
  if (el) {
    el.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') loginBtn.click();
    });
  }
});

// -------------------- Display logged username on index.html --------------------
window.addEventListener('DOMContentLoaded', () => {
  const loggedUser = localStorage.getItem('loggedUser');
  const userGreeting = document.getElementById('user-greeting');

  if (loggedUser && userGreeting) {
    userGreeting.textContent = `Hello, ${loggedUser} 👋`;
    userGreeting.style.fontWeight = '600';
    userGreeting.style.color = '#2c3e50';
    userGreeting.style.marginLeft = '20px';
  }
});
