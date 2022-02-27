<template>
  <div class="container">
    <div class="row">
      <div class="col-md-5 mr-auto">
        <h2>Contact Us</h2>
        <p class="mb-5">
          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Iste quaerat
          autem corrupti asperiores accusantium et fuga! Facere excepturi, quo
          eos, nobis doloremque dolor labore expedita illum iusto, aut repellat
          fuga!
        </p>
        <ul class="list-unstyled pl-md-5 mb-5">
          <li class="d-flex text-black mb-2">
            <span class="mr-3"><span class="icon-map"></span></span> Placeholder
            Street, Placeholder City, <br/>
            Placeholder Country
          </li>
          <li class="d-flex text-black mb-2">
            <span class="mr-3"><span class="icon-phone"></span></span> +1 (222)
            345 6789
          </li>
          <li class="d-flex text-black">
            <span class="mr-3"><span class="icon-envelope-o"></span></span>
            info@mywebsite.com
          </li>
        </ul>
      </div>
      <div class="col-md-6">
        <form id="contactForm" class="mb-5" name="contactForm">
          <div class="row">
            <div class="col-md-12 form-group">
              <label class="col-form-label" for="name">Name</label>
              <input id="name" class="form-control" name="name" type="text"/>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 form-group">
              <label class="col-form-label" for="email">Email</label>
              <input id="email" class="form-control" name="email" type="text"/>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 form-group">
              <label class="col-form-label" for="message">Message</label>
              <textarea
                  id="message"
                  class="form-control"
                  cols="30"
                  name="message"
                  rows="7"
              ></textarea>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <input
                  class="btn btn-primary rounded-0 py-2 px-4 mt-4"
                  type="submit"
                  value="Send Message"
              />
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ContactPage",
};
</script>

<style scoped></style>
