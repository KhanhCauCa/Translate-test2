import { Component, OnInit } from '@angular/core';
import { TranslationService } from '../services/translation.service';
@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css'],
})
export class BodyComponent implements OnInit {
  public input: string = '';
  public inputType: string | null = null;
  public outputType: string | null = null;
  public translatedText: string = '';

  ListDataTypes= ["String", "Base64", "Hex", "Byte"];
  constructor(private translationService: TranslationService) {}

  ngOnInit(): void {}

  swapLanguages(): void {
    const temp = this.inputType;
    this.inputType = this.outputType;
    this.outputType = temp;
  }

  translate(): void {
    if (this.inputType && this.outputType) {
      this.translationService.translateText(this.input, this.inputType, this.outputType)
      .subscribe(
        (response: any) => {
          // console.log('API Response:', response);  // Kiểm tra phản hồi từ API
          this.translatedText = response;  // Cập nhật thuộc tính này
          console.log(this.translatedText)
        },
        (error: any) => {
          console.error(error);
        }
        );
    }
    else{
      alert('Hãy lựa chọn kiểu dữ liệu cần chuyển đổi ')
    }
  }
}
