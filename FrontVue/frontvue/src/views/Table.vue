<template>
    <div class="table">
        <div class='selector'>
            <router-link to='/static-table'>Dane w tabeli statyczne</router-link>
            <router-link to='/dynamic-table'>Dane z REST API</router-link>
        </div>
    </div>
</template>

<script>
export default {
  name: 'Table',
};
</script>
