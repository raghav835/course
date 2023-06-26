onClickSubmit() {

  // Get the form values
  const formValues = this.loginForm.value;

  // Call the AuthService to login the user
  this.authService.login(formValues).subscribe(
    () => {
      // Redirect the user to the home page
      this.router.navigate(['/']);
    },
    (    error: any) => {
      // Show an error message
      console.error(error);
    },
  );
}
function onClickSubmit() {
  throw new Error("Function not implemented.");
}

