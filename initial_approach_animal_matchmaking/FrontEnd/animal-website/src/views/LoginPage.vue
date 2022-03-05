<template>
  <section class="vh-100 gradient-custom mb-0">
    <div class="container h-100 overflow-hidden">
      <div
          class="row d-flex justify-content-center align-items-center h-100 mt-4 overflow-hidden"
      >
        <div class="col-12 col-md-8 col-lg-6 col-xl-5">
          <div class="card bg-dark text-white" style="border-radius: 1rem">
            <div class="card-body p-5 text-center">
              <form class="mb-md-5 mt-md-4 pb-5" @submit.prevent="login">
                <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                <p class="text-white-50 mb-5"></p>

                <div class="form-outline form-white mb-4">
                  <label class="form-label" for="username">Username</label>
                  <input
                      id="username"
                      v-model="input.username"
                      class="form-control form-control-lg"
                      name="username"
                      placeholder="Username"
                      required
                      type="text"
                  />
                </div>

                <div class="form-outline form-white mb-4">
                  <label class="form-label" for="pwd">Password</label>
                  <input
                      id="pwd"
                      v-model="input.password"
                      class="form-control form-control-lg"
                      name="pwd"
                      placeholder="Password"
                      required
                      type="password"
                  />
                </div>

                <div class="form-outline mb-4">
                  <label class="form-label">Account Type</label>
                  <select v-model="acctype" class="form-select">
                    <option v-bind:value="`adder`">Adder</option>
                    <option v-bind:value="`adopter`">Adopter</option>
                  </select>
                </div>

                <button class="btn btn-outline-light btn-lg px-5" type="submit">
                  Login
                </button>
              </form>
              <p v-if="response">{{ response }}</p>

              <div>
                <p class="mb-0">
                  Don't have an account?
                  <router-link class="text-white-50 fw-bold" to="/register"
                  >Sign Up
                  </router-link>
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
import AuthService from "@/services/AuthService";

export default {
  name: "LoginPage",
  data() {
    return {
      input: {
        username: "",
        password: "",
      },
      acctype: "adder",
      response: "",
    };
  },
  methods: {
    async login() {
      try {
        const credentials = this.input;
        const result =
            this.acctype === "adder"
                ? await AuthService.loginAdder(credentials)
                : await AuthService.loginAdopter(credentials);
        this.response = result.msg;
        const token = result.token;
        const user = result.user;
        this.$store.dispatch("login", {token, user});
        await this.$router.push(
            this.acctype === "adder" ? "/AdderPage" : "/AdopterPage"
        );
      } catch (e) {
        this.response = e.message;
      }
    },
  },
};
</script>

<style lang="scss" scoped></style>
