import {ChangeDetectionStrategy, Component, DestroyRef, inject, signal} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MessagesService} from '../../messages.service';
import {MessageResponse} from '../../model/messages.model';
import {takeUntilDestroyed} from '@angular/core/rxjs-interop';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'devops-messages',
  imports: [CommonModule],
  standalone: true,
  templateUrl: './messages.component.html',
  styles: [`
    $primary-color: #3f51b5;
    $bg-color: #f8f9fa;
    $border-color: #dee2e6;
    $text-dark: #333;

    .message-container {
      padding: 2rem;
      border-radius: 8px;

      .table-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 1.5rem;

        h4 {
          margin: 0;
          color: $primary-color;
          font-size: 1.5rem;
          font-weight: 600;
        }
      }
    }

    .styled-table {
      width: 100%;
      border-collapse: collapse;
      background: white;
      border-radius: 8px 8px 0 0;
      overflow: hidden;

      thead tr {
        background-color: $primary-color;
        color: #ffffff;
        text-align: left;
        font-weight: bold;
      }

      th, td {
        padding: 12px 15px;
        border-bottom: 1px solid $border-color;
      }

      tbody tr {
        &:nth-of-type(even) {
          background-color: #f3f3f3;
        }

        &:last-of-type {
          border-bottom: 2px solid $primary-color;
        }

        &:hover {
          background-color: rgba($primary-color, 0.05);
          transition: background 0.2s ease;
        }
      }

      .content-cell {
        max-width: 300px;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
      }

      .badge-user {
        background: #e0e0e0;
        padding: 4px 8px;
        border-radius: 12px;
        font-size: 0.85rem;
      }

      .no-data {
        text-align: center;
        padding: 2rem;
        color: #888;
      }
    }

    .text-center {
      text-align: center;
    }
  `],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class MessagesComponent {

  private _messagesService = inject(MessagesService);
  private _destroyRef = inject(DestroyRef);

  // 1. Initialize as a signal
  protected messages = signal<MessageResponse[]>([]);

  constructor() {
    this._messagesService.messages()
      .pipe(takeUntilDestroyed(this._destroyRef))
      .subscribe({
        next: (response: MessageResponse[]) => {
          // 2. Update the signal value
          this.messages.set(response);
        },
        error: (error: HttpErrorResponse) => console.error(error)
      });
  }
}
