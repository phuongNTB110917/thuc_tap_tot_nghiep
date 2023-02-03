import {Component, ElementRef, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {AbstractControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SecurityService} from '../service/security.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {ShareService} from '../service/share.service';
import {TokenStorageService} from '../../_services/token-storage.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  formSignup: FormGroup;
  isLogin = false;
  @Input() typeForm: string;

  @Output() newItemEvent = new EventEmitter<string>();


  validationMessages = {
    username: [
      {type: 'required', message: 'Họ và tên không được để trống.'},
      {type: 'maxlength', message: 'Họ và tên không quá 100 kí tự.'},
      {type: 'pattern', message: 'Họ và tên không chứa kí tự đặc biệt.'}
    ],
    email: [
      {type: 'required', message: 'Email không được để trống.'},
      {type: 'email', message: 'Email không đúng định dạng.'}
    ],
    password: [
      {type: 'required', message: 'Mật khẩu không được để trống.'},
      {type: 'minlength', message: 'Mật khẩu dài từ 8-32 kí tự.'},
      {type: 'maxlength', message: 'Mật khẩu dài từ 8-32 kí tự.'}
    ],
    confirmPass: [
      {type: 'required', message: 'Mật khẩu không được để trống.'},
      {type: 'minlength', message: 'Mật khẩu dài từ 8-32 kí tự.'},
      {type: 'maxlength', message: 'Mật khẩu dài từ 8-32 kí tự.'}
    ]
  };

  get username() {
    return this.formSignup.get('username');
  }

  get email() {
    return this.formSignup.get('email');
  }


  get password() {
    return this.formSignup.get('pwGroup').get('password');
  }

  get confirmPass() {
    return this.formSignup.get('pwGroup').get('confirmPass');
  }

  constructor(private el: ElementRef,
              private formBuild: FormBuilder,
              private securityService: SecurityService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private tokenStorageService: TokenStorageService,
              private shareService: ShareService) { }

  ngOnInit() {
    this.formSignup = this.formBuild.group({
      username: ['', [Validators.required, Validators.maxLength(100),
        Validators.pattern('^([a-zA-Z ]+)*$')]],
      email: ['', [Validators.required, Validators.email, Validators. pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')]],
      pwGroup: this.formBuild.group({
        password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(32)]],
        confirmPass: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(32)]]
      }, this.comparePass)
      }
    );
  }

  comparePass(c: AbstractControl) {
    const v = c.value;
    if (v.password === v.confirmPass) {
      return null;
    }
    return {passwordNotMatch: true};
  }


  onSave() {
    if (this.formSignup.valid) {
      console.log(this.formSignup.value);
      const registerRequest = {
        email: this.email.value,
        username: this.username.value,
        password: this.password.value,
        confirmPass: this.confirmPass.value
      };
      this.securityService.signup(registerRequest).subscribe(
        data => {
          this.toastr.success(data.message, 'Thông báo');
          this.router.navigateByUrl('/login');
        },
        error => {
          this.toastr.error(error.error.message, 'Thông báo');
        });
    }
  }

  togglePassword(idInput: string, idToggle: string) {
    const input = this.el.nativeElement.querySelector(idInput);
    const toggle = this.el.nativeElement.querySelector(idToggle);
    const typeInput = input.type === 'text' ? 'password' : 'text';
    input.setAttribute('type', typeInput);
    toggle.classList.toggle('bi-eye-slash');
    toggle.classList.toggle('bi-eye');
  }

}
