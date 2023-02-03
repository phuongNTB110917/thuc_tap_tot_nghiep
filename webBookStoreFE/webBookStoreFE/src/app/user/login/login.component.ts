import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {SecurityService} from '../service/security.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ShareService} from '../service/share.service';
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup;
  isLogin = false;


  constructor(private formBuild: FormBuilder,
              private securityService: SecurityService,
              private router: Router,
              private route: ActivatedRoute,
              private toastr: ToastrService,
              private shareService: ShareService) { }

  ngOnInit(): void {
    this.formLogin = this.formBuild.group({
        username: ['', [Validators.required]],
        password: ['', [Validators.required, Validators.minLength(8), Validators.maxLength(32)]]
      }
    );
  }

  onSubmit() {
    this.securityService.login(this.formLogin.value).subscribe(
      data => {
        this.toastr.success('Đăng nhâp thành công');
        console.log(data);

        /* Store info user*/
        localStorage.setItem('userData', JSON.stringify(data));
        this.formLogin.reset();
        this.router.navigateByUrl('/');
        this.shareService.sendClickEvent();
      },
      err => {
        console.log(err.error.message);
        this.isLogin = true;
        this.toastr.error('Sai tên đăng nhập hoặc mật khẩu hoặc tài khoản chưa được kích hoạt', 'Đăng nhập thất bại: ', {
          // positionClass: 'toast-top-right',
          // timeOut: 3000,
          // extendedTimeOut: 1500
        });
      }
    );
  }
}
