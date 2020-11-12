import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Subscription } from 'rxjs';
import { ClueResult } from './crossword.interface';
import { CrosswordService } from './crosswordservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  clue = new FormControl('');

  subscriptions: Subscription[];
  results = [] as ClueResult[];

  constructor(private readonly crossWordService: CrosswordService) {}

  onSubmit() {
    this.crossWordService.submitClue(this.clue.value).subscribe((response: ClueResult[]) => {
      this.results = response && response.length > 0 ? response : [];
    });
  }

  onClear() {
    this.results = [];
  }
}
