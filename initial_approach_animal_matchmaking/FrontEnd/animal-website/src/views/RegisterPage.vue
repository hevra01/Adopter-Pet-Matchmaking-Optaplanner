<template>
  <div class="mask d-flex align-items-center h-100 gradient-custom-3 overflow-hidden">
    <div class="container h-100 overflow-hidden">
      <div class="row d-flex justify-content-center align-items-center h-100 mt-3 overflow-hidden">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card bg-dark text-white" style="border-radius: 15px;">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Create an account</h2>

              <form>

                <div class="form-outline mb-4">
                  <input id="form3Example1cg" class="form-control form-control-lg" type="text"/>
                  <label class="form-label" for="form3Example1cg">Your Name</label>
                </div>

                <div class="form-outline mb-4">
                  <input id="form3Example3cg" class="form-control form-control-lg" type="email"/>
                  <label class="form-label" for="form3Example3cg">Your Email</label>
                </div>

                <div class="form-outline mb-4">
                  <input id="form3Example4cg" class="form-control form-control-lg" type="password"/>
                  <label class="form-label" for="form3Example4cg">Password</label>
                </div>

                <div class="form-outline mb-4">
                  <input id="form3Example4cdg" class="form-control form-control-lg" type="password"/>
                  <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                </div>

                <div class="d-flex justify-content-center">
                  <button class="btn btn-outline-light btn-lg px-5" type="button">Register
                  </button>
                </div>

                <p class="text-center text-muted mt-4 mb-0">Have already an account?
                  <router-link class="fw-bold text-white" to="/"><u>Login here</u></router-link>
                </p>

              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "RegisterPage"
}
</script>

<style scoped>

</style>