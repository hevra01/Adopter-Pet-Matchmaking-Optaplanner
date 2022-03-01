<template>
  <div class="col-2 d-flex flex-column align-self-center">
    <h1>Hi {{ fname }}</h1>
    <router-link
        class="btn btn-dark btn-outline-light border-0 btn-lg px-5 mb-4"
        to=""
    >Adopt a Pet
    </router-link>
    <router-link
        class="btn btn-dark btn-outline-light border-0 btn-lg px-5 mb-4"
        to=""
    >Current Pets
    </router-link>
    <button
        class="btn btn-dark btn-outline-light border-0 btn-lg px-5"
        @click="logout"
    >
      Logout
    </button>
  </div>
</template>

<script>
export default {
  name: "AdopterPage",
  data() {
    return {
      fname: "",
    };
  },
  async created() {
    if (!this.$store.getters.isLoggedIn) {
      await this.$router.push("/");
    }
    this.fname = this.$store.getters.getUser.fname;
  },
  methods: {
    logout() {
      this.$store.dispatch("logout");
      this.$router.push("/");
    },
  },
};
</script>

<style scoped></style>
