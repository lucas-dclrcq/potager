<template>
  <form>
    <h1 class="title">Create your garden</h1>
    <article v-if="error" class="message is-danger">
      <div class="message-header">
        <p>An error occured while creating new garden</p>
        <button class="delete" aria-label="delete"></button>
      </div>
      <div class="message-body">
        {{this.error}}
      </div>
    </article>
    <div class="field">
      <label class="label">Name</label>
      <div class="control">
        <input v-model="name" class="input" type="text" placeholder="The name of your garden">
      </div>
    </div>
    <div class="field">
      <label class="label">Width</label>
      <div class="control">
        <input v-model="width" class="input" type="number" placeholder="The width of your garden in number of squares">
      </div>
    </div>
    <div class="field">
      <label class="label">Height</label>
      <div class="control">
        <input v-model="height" class="input" type="number"
               placeholder="The height of your garden in number of squares">
      </div>
    </div>
    <div class="field is-grouped is-grouped-right">
      <p class="control">
        <a @click="createGarden" class="button is-primary">
          Create
        </a>
      </p>
    </div>
  </form>
</template>

<script>
import router from "@/router";
import axios from "axios";

export default {
  data() {
    return {
      name: "",
      height: 0,
      width: 0,
      error: null
    }
  },
  methods: {
    createGarden() {
      axios.post("http://localhost:8080/gardens", {
          name: this.name,
          height: this.height,
          width: this.width
      }).then(() => router.push({name: 'Garden'}))
          .catch(err => this.error = err);
    }
  }
}


</script>

<style scoped>

</style>