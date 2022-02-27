<template>
  <div class="mask d-flex align-items-center gradient-custom-3 overflow-hidden">
    <div class="container h-100 overflow-hidden">
      <div
          class="row d-flex justify-content-center align-items-center h-100 mt-3 overflow-hidden"
      >
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card bg-dark text-white" style="border-radius: 15px">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Create an account</h2>

              <form @submit.prevent="signUp">
                <div class="form-outline mb-4 row">
                  <div class="col">
                    <label class="form-label" for="fname">First Name</label>
                    <input
                        id="fname"
                        class="form-control form-control-lg"
                        type="text"
                    />
                  </div>
                  <div class="col">
                    <label class="form-label" for="lname">Last Name</label>
                    <input
                        id="lname"
                        class="form-control form-control-lg"
                        type="text"
                    />
                  </div>
                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="email">Your Email</label>
                  <input
                      id="email"
                      class="form-control form-control-lg"
                      type="email"
                  />
                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="pwd">Password</label>
                  <input
                      id="pwd"
                      class="form-control form-control-lg"
                      type="password"
                  />
                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="pwdr"
                  >Repeat your password</label
                  >
                  <input
                      id="pwdr"
                      class="form-control form-control-lg"
                      type="password"
                  />
                </div>
                <div class="form-outline mb-4">
                  <label class="form-label" for="tel">Phone Number</label>
                  <input
                      id="tel"
                      class="form-control form-control-lg"
                      type="tel"
                  />
                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="tel"
                  >How Will You Use This Service?</label
                  >
                  <select v-model="uinfo.acctype" class="form-select">
                    <option v-bind:value="`adder`">
                      Put a Pet Up for Adoption
                    </option>
                    <option v-bind:value="`adopter`">Adopt a Pet</option>
                  </select>
                </div>

                <div class="d-flex justify-content-center">
                  <button
                      class="btn btn-outline-light btn-lg px-5"
                      type="submit"
                  >
                    Register
                  </button>
                </div>
              </form>
              <p class="text-center text-muted mt-4 mb-0">
                Have already an account?
                <router-link class="fw-bold text-white" to="/"
                ><u>Login here</u></router-link
                >
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AuthService from "@/services/AuthService";

export default {
  name: "RegisterPage",
  data() {
    return {
      uinfo: {
        fname: "",
        lname: "",
        email: "",
        pwd: "",
        pwdr: "",
        tel: "",
        acctype: "adder",
      },
      response: "",
    };
  },
  methods: {
    async signUp() {
      try {
        const credentials = this.uinfo;
        const result = await AuthService.signUp(credentials);
        this.response = result.msg;
        this.$router.push("/");
      } catch (e) {
        this.response = e.response.data.msg;
      }
    },
  },
};
</script>

<style scoped></style>
