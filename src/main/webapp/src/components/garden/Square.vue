<template>
  <div class="dropdown is-hoverable">
    <div class="dropdown-trigger">
      <div class="garden-square" :class="{'garden-square-cultivated': square.type === 'CULTIVATED'}" aria-haspopup="true" aria-controls="dropdown-menu2">
         {{ square.type }}
      </div>
    </div>
    <div class="dropdown-menu square-menu" id="dropdown-menu2" role="menu">
      <div class="dropdown-content">
        <div class="dropdown-item">
          <p>{{square.id}}</p>
        </div>
        <hr class="dropdown-divider"/>
        <div class="dropdown-item">
          <div class="select">
            <select v-model="this.$props.square.type">
              <option>EMPTY</option>
              <option>CULTIVATED</option>
            </select>
          </div>
        </div>
        <hr class="dropdown-divider"/>
        <p class="dropdown-item">
          ttt ttt ttt
        </p>
        <hr class="dropdown-divider">
        <a href="#" class="dropdown-item">
          <button class="button is-success">Save changes</button>
          <button class="button">Cancel</button>
        </a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Square',
  props: ['square', 'x', 'y']
}
</script>

<style scoped>
.garden-square {
  height: 100px;
  width: 100px;
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  border: 1px dotted black;
  margin-left: -1px;
  margin-top: -1px;
}

.square-menu {
}

.garden-square-empty {
  background: transparent;
}

.garden-square-cultivated {
  background-color: rgb(205, 133, 63);
}
</style>