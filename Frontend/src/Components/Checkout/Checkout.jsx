

export const payment = async (amount) => {
  return new Promise((resolve) => {
    const loadScript = (src) => {
      return new Promise((resolve) => {
        const script = document.createElement("script");
        script.src = src;

        script.onload = () => {
          resolve(true);
        };

        script.onerror = () => {
          resolve(false);
        };

        document.body.appendChild(script);
      });
    };

    const displayRazorpay = async (amount) => {
      const res = await loadScript(
        "https://checkout.razorpay.com/v1/checkout.js"
      );

      if (!res) {
        alert("You are offline... Failed to load Razorpay SDK");
        resolve(false);
        return;
      }

      const options = {
        key: "rzp_test_VdGdvprTKB8u1w",
        currency: "INR",
        amount: amount * 100,
        name: "Thomas Cook",
        description: "Thanks for purchasing",

      

        prefill: {
          name: "Thomas Cook",
        },
      };

      const paymentObject = new window.Razorpay(options);
      paymentObject.open();
    };

    displayRazorpay(amount);
  });
};
