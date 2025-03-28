import { ChangeDetectionStrategy, Component, inject, signal } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { UserRegistration } from 'src/app/models/UserRegistration.model';
//should work at root level 
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';

@Component({
  selector: 'app-registration-form',
  imports: [FormsModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, MatIconModule, MatButtonModule],
  templateUrl: './registration-form.component.html',
  styleUrl: './registration-form.component.scss',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class RegistrationFormComponent {

  private userService = inject(UserService);
  
  public hide = signal(true);
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

  public registrationForm!: FormGroup;
  constructor() {
    this.registrationForm = new FormGroup({
      username: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    })
  }

  public onSubmit(): void {
    const user: UserRegistration = {
      username: this.registrationForm.value.username,
      email: this.registrationForm.value.email, 
      password: this.registrationForm.value.password
    } 
    this.userService.registerUser(user).subscribe({
      next: (response: any) => {
        console.log(response);
      },
      error: (err) => {
        console.warn(err);
      }
    })
  }

}
