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
  public error: string | null = null;

  ListDataTypes= ["String", "Base64", "Hex", "Byte"];
  constructor(private translationService: TranslationService) {}

  ngOnInit(): void {}

  swapLanguages(): void {
    const temp = this.inputType;
    this.inputType = this.outputType;
    this.outputType = temp;

    const text = this.input;
    this.input = this.translatedText
    this.translatedText = text;
  }

  translate(): void {
    if (this.inputType && this.outputType) {
      this.translationService.translateText(this.input, this.inputType, this.outputType)
      .subscribe(
        (response: any) => {
          this.translatedText = response;
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
