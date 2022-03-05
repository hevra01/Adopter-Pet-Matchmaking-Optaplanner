<template>
  <div class="mask d-flex align-items-center gradient-custom-3 overflow-hidden">
    <div class="container h-100 overflow-hidden">
      <div
          class="row d-flex justify-content-center align-items-center h-100 mt-3 overflow-hidden"
      >
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card bg-dark text-white" style="border-radius: 15px">
            <div class="card-body p-5">
              <h2 class="text-uppercase text-center mb-5">Please Fill the Pet's Information</h2>

              <form @submit.prevent="AddPet">

                <div class="form-outline mb-4">
                  <label class="form-label" for="type">Pet Type</label>
                  <select id="type" v-model="petinfo.AnimalType" class="form-select" name="type">
                    <option v-bind:value="`D`">Dog</option>
                    <option v-bind:value="`C`">Cat</option>
                  </select>
                </div>
                <div class="form-outline mb-4">
                  <label class="form-label" for="expenses">Pet's Expenses (Value in Dollars)</label>
                  <input id="expenses" v-model="petinfo.Expenses" class="form-control form-control" required
                         type="number"/>
                </div>

                <div class="form-outline mb-4">
                  <label class="form-label" for="emotion">How Emotional is your Pet?</label>
                  <input id="emotion" v-model="petinfo.EmotionalNeed" class="form-range" max="10" min="1" name="emotion"
                         step="0.5"
                         type="range"/><span>{{ petinfo.EmotionalNeed }}</span>
                </div>
                <div class="form-outline mb-4">
                  <label class="form-label" for="physical">How Active is your Pet?</label>
                  <input id="physical" v-model="petinfo.PhysicalActivityNeed" class="form-range" max="10" min="1"
                         name="physical" step="0.5"
                         type="range"/><span>{{ petinfo.PhysicalActivityNeed }}</span>
                </div>
                <div class="form-outline mb-4">
                  <label class="form-label" for="shy">How Shy is your Pet?</label>
                  <input id="shy" v-model="petinfo.ShynessLevel" class="form-range" max="10" min="1" name="shy"
                         step="0.5"
                         type="range"/><span>{{ petinfo.ShynessLevel }}</span>
                </div>
                <div class="form-outline mb-4">
                  <label class="form-label" for="age">How Old is Your Pet? (In Months)</label>
                  <input id="age" v-model="petinfo.Age" class="form-control form-control" required
                         type="number"/>
                </div>
                <div class="d-flex justify-content-center">
                  <p v-if="response" class="text-danger">{{ response }}</p>
                </div>
                <div class="d-flex justify-content-center">
                  <button
                      class="btn btn-outline-light btn-lg px-5"
                      type="submit"
                  >
                    Put Up For Adoption
                  </button>
                </div>
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "AnimalAddPage",
  data() {
    return {
      petinfo: {
        AnimalType: "D",
        Expenses: 0,
        EmotionalNeed: 1,
        PhysicalActivityNeed: 1,
        ShynessLevel: 1,
        Age: 1,
        Adopted: false,
        Alive: true, //Why do we need this again?
      },
      response: ""
    };
  },
  methods: {
    async AddPet() {
      try {
        await axios.post("placeholder/api/adderanimal/add")
            .then((answer) => {
              this.response = answer.message;
            });
        await this.$router.push("/AdderPage");
      } catch (e) {
        this.response = e.message;
      }
    }
  },
  // async created() {
  //   if (!this.$store.getters.isLoggedIn || this.$store.getters.getUser.acctype !== "adopter") {
  //     await this.$router.push("/");
  //   }
  // },
}
</script>

<style scoped>

</style>