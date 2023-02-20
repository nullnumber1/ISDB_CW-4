async function submitLoginForm() {
    const username = (document.getElementById("login-username") as HTMLInputElement).value;
    const password = (document.getElementById("login-password") as HTMLInputElement).value;
    let response = await fetch("http://localhost:9000/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(
            {
                "username": username,
                "password": password
            }
        ),
    }).then(response => {
        if (response.ok) {
            console.log("Request successful");
            return response;
        } else {
            console.error("No token");
        }
    });
    // Print all info about request
    const token = await response.text();
    if (token) {
        localStorage.setItem("token", token);
        console.log("Login successful!");
        // Navigate to main page through navigate
        window.location.href = "main.html";

    } else {
        console.log("Login failed");
    }
}

async function signOut() {
    localStorage.removeItem("token");
    window.location.href = "login.html";
}

async function setUsername() {
    const token = localStorage.getItem("token");
    if (token) {
        const payload = JSON.parse(atob(token.split(".")[1]));
        const username = payload.iss;
        document.getElementById("username-display").innerHTML = username;
    }
}

async function submitRegisterForm() {
    const username = (document.getElementById("register-username") as HTMLInputElement).value;
    const password = (document.getElementById("register-password") as HTMLInputElement).value;
    const response = await fetch("http://localhost:9000/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({username, password}),
    });
    if (response.ok) {
        console.log("Registration successful!");
    } else {
        console.error("Registration failed");
    }
}
