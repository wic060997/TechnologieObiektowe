<template>
    <div class="dynamic-table">
      <p>Lorem gipsum Dynamic Table</p>

      <div class='selector'>
            <router-link to='/dynamic-table/simple'>1 Dana</router-link>
            <router-link to='/dynamic-table/data1k'>1k Danych</router-link>
        </div>
    </div>
</template>

<script>
export default {
  name: 'DynamicTable',
};
</script>
