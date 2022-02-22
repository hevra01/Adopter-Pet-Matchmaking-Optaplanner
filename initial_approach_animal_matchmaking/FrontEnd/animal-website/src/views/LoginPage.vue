<template>
  <section class="vh-100 gradient-custom mb-0">
    <div class="container h-100 overflow-hidden">
      <div class="row d-flex justify-content-center align-items-center h-100 mt-4 overflow-hidden">
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-dark text-white" style="border-radius: 1rem;">
            <div class="card-body p-5 text-center">

              <form class="mb-md-5 mt-md-4 pb-5" @submit.prevent="login">

                <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                <p class="text-white-50 mb-5"></p>

                <div class="form-outline form-white mb-4">
                  <label class="form-label" for="email">Email</label>
                  <input id="email" v-model="input.email" class="form-control form-control-lg" name="email"
                         placeholder="Email" required type="email"/>
                </div>

                <div class="form-outline form-white mb-4">
                  <label class="form-label" for="pwd">Password</label>
                  <input id="pwd" v-model="input.password" class="form-control form-control-lg" name="pwd"
                         placeholder="Password" required type="password"/>
                </div>

                <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>

              </form>

              <div>
                <p class="mb-0">Don't have an account?
                  <router-link class="text-white-50 fw-bold" to="/register">Sign Up</router-link>
                </p>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginPage",
  data() {
    return {
      input: {
        email: "",
        password: ""
      },
      response: ""
    }
  },
  methods: {
    login() {
      axios({
        method: "POST",
        "url": "192.168.0.180:5555",
        "data": this.input,
        "headers": {"content-type": "application/json"}
      }).then(result => {
        this.response = result.data;
        localStorage.setItem("user", this.response.data.token);
      }, error => {
        console.error(error);

      });
    }
  }
}
</script>

<style lang="scss" scoped>

</style>